package com.supinfo.javaparadise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.supinfo.javaparadise.entities.Place;
import com.supinfo.javaparadise.entities.Trip;

public class JdbcTripDao implements TripDao
{
    private Connection connection;
    
    public JdbcTripDao(Connection connection)
    {
        this.connection = connection;
    }
    
    @Override
    public long createTrip(Trip t)
    {
        try(PreparedStatement pstmt = this.connection.prepareStatement("INSERT INTO trips (destination, departure, price) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setLong(1, t.getDestination().getId());
            pstmt.setLong(2, t.getDeparture().getId());
            pstmt.setBigDecimal(3, t.getPrice());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) 
            {
                if (generatedKeys.next()) 
                {
                    t.setId(generatedKeys.getLong(1));
                    return t.getId();
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Trip findTripById(long id)
    {
        try(PreparedStatement pstmt = this.connection.prepareStatement("SELECT t.*, dest.name as destinationname, dept.name as departurename FROM trips t LEFT JOIN places dest ON dest.id = t.destination LEFT JOIN places dept ON dept.id = t.departure WHERE t.id=?"))
        {
            pstmt.setLong(1, id);
            ResultSet result = pstmt.executeQuery();
            if(result.first())
            {
                Trip t = new Trip();
                t.setId(result.getLong("id"));
                t.setPrice(result.getBigDecimal("price"));
                
                Place destination = new Place();
                destination.setId(result.getLong("destination"));
                destination.setName(result.getString("destinationname"));
                
                Place departure = new Place();
                departure.setId(result.getLong("departure"));
                departure.setName(result.getString("departurename"));
                
                t.setDestination(destination);
                t.setDeparture(departure);
                return t;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean removeTrip(Trip t)
    {
        try(PreparedStatement pstmt = this.connection.prepareStatement("DELETE FROM trips WHERE id=?"))
        {
            pstmt.setLong(1, t.getId());
            pstmt.executeUpdate();
            return pstmt.getUpdateCount() > 0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
}