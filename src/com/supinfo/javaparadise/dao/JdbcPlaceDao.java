package com.supinfo.javaparadise.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.supinfo.javaparadise.entities.Place;

public class JdbcPlaceDao implements PlaceDao
{
    private Connection connection;

    public JdbcPlaceDao(Connection connection)
    {
        this.connection = connection;
    }
    
    @Override
    public long createPlace(Place p)
    {
        try(PreparedStatement pstmt = this.connection.prepareStatement("INSERT INTO places (name) VALUES (?)", Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setString(1, p.getName());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) 
            {
                if (generatedKeys.next()) 
                {
                    p.setId(generatedKeys.getLong(1));
                    return p.getId();
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
    public Place findPlaceById(long id)
    {
        try(PreparedStatement pstmt = this.connection.prepareStatement("SELECT * FROM places WHERE id=?"))
        {
            pstmt.setLong(1, id);
            ResultSet result = pstmt.executeQuery();
            if(result.first())
            {
                Place p = new Place();
                p.setId(result.getLong("id"));
                p.setName(result.getString("name"));
                return p;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updatePlace(Place p)
    {
        try(PreparedStatement pstmt = this.connection.prepareStatement("UPDATE places SET name=? WHERE id=?"))
        {
            pstmt.setString(1, p.getName());
            pstmt.setLong(2, p.getId());
            pstmt.executeUpdate();
            return pstmt.getUpdateCount() > 0;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removePlace(Place p)
    {
        try(PreparedStatement pstmt = this.connection.prepareStatement("DELETE FROM places WHERE id=?"))
        {
            pstmt.setLong(1, p.getId());
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