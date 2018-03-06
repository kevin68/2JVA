package com.supinfo.javaparadise;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.supinfo.javaparadise.dao.JdbcPlaceDao;
import com.supinfo.javaparadise.dao.JdbcTripDao;
import com.supinfo.javaparadise.entities.Place;
import com.supinfo.javaparadise.entities.Trip;

public class Launcher
{
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        Connection connection = null;
        try
        {
            // -> MYSQL
            Class.forName(com.mysql.jdbc.Driver.class.getName());

            // -> PostgreSQL
            // Class.forName(org.postgresql.Driver.class.getName());

            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/javaparadise", "javaparadise", "1234");

            JdbcPlaceDao placeDao = new JdbcPlaceDao(connection);
            JdbcTripDao tripDao = new JdbcTripDao(connection);

            while(true)
            {
                System.out.println("What do you want to do ?");
                System.out.println("1 - Add a place");
                System.out.println("2 - Find a place");
                System.out.println("3 - Edit a place");
                System.out.println("4 - Remove a place");
                System.out.println("5 - Add a trip");
                System.out.println("6 - Find a trip");
                System.out.println("7 - Remove a trip");
                System.out.println("8 - Quit");
                try
                {
                    int value = askForInt();
                    switch(value)
                    {
                        case 1:
                            System.out.println("Enter the name of the place: ");
                            Place p = new Place();
                            p.setName(askForString());
                            placeDao.createPlace(p);
                            System.out.println("Place created with the id: " + p.getId());
                            break;
                        case 2:
                            System.out.println("Enter the id of the place: ");
                            Place p2 = placeDao.findPlaceById(askForLong());
                            System.out.println("Place : " + (p2 == null ? "Not found" : p2.getName()));
                            break;
                        case 3:
                            System.out.println("Enter the id of the place: ");
                            Place p3 = placeDao.findPlaceById(askForLong());
                            System.out.println("Place : " + (p3 == null ? "Not found" : p3.getName()));
                            if(p3 != null)
                            {
                                System.out.println("Enter the new name of the place: ");
                                p3.setName(askForString());
                                System.out.println("Place updated: " + placeDao.updatePlace(p3));
                            }
                            break;
                        case 4:
                            System.out.println("Enter the id of the place: ");
                            Place p4 = placeDao.findPlaceById(askForLong());
                            System.out.println("Place : " + (p4 == null ? "Not found" : p4.getName()));
                            if(p4 != null)
                            {
                                System.out.println("Place removed: " + placeDao.removePlace(p4));
                            }
                            break;
                        case 5:
                            System.out.println("Enter the id of the departure: ");
                            Place p5 = placeDao.findPlaceById(askForLong());
                            System.out.println("Place : " + (p5 == null ? "Not found" : p5.getName()));
                            if(p5 != null)
                            {
                                System.out.println("Enter the id of the destination: ");
                                Place p6 = placeDao.findPlaceById(askForLong());
                                System.out.println("Place : " + (p6 == null ? "Not found" : p6.getName()));
                                if(p6 != null)
                                {
                                    System.out.println("Price: ");
                                    Trip t = new Trip();
                                    t.setDestination(p5);
                                    t.setDeparture(p6);
                                    t.setPrice(askForDecimal());
                                    tripDao.createTrip(t);
                                    System.out.println("Trip created with id: " + t.getId());
                                }
                            }
                            break;
                        case 6:
                            System.out.println("Enter the id of the trip: ");
                            Trip t2 = tripDao.findTripById(askForLong());
                            if(t2 != null)
                            {
                                System.out.println("Trip id : " + t2.getId());
                                System.out.println("Trip from : " + t2.getDeparture().getName());
                                System.out.println("Trip to : " + t2.getDestination().getName());
                                System.out.println("Trip cost : " + t2.getPrice());
                            }
                            else   
                            {
                                System.out.println("Trip not found");
                            }
                            break;
                        case 7:
                            System.out.println("Enter the id of the trip: ");
                            Trip t3 = tripDao.findTripById(askForLong());
                            if(t3 != null)
                            {
                                System.out.println("Trip id : " + t3.getId());
                                System.out.println("Trip removed : " + tripDao.removeTrip(t3));
                            }
                            else   
                            {
                                System.out.println("Trip not found");
                            }
                            break;
                        case 8:
                            return;
                        default:
                            System.out.println("Invalid input");
                            break;
                    }
                }
                catch(NumberFormatException ex)
                {
                    System.out.println("Invalid input");
                }
                System.out.println();
            }
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(connection != null)
            {
                try
                {
                    connection.close();
                }
                catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }
            sc.close();
        }
    }

    private static String askForString()
    {
        String line = sc.nextLine();
        return line;
    }
    
    private static BigDecimal askForDecimal() throws NumberFormatException
    {
        return new BigDecimal(askForString());
    }

    private static int askForInt() throws NumberFormatException
    {
        return Integer.valueOf(askForString());
    }

    private static long askForLong() throws NumberFormatException
    {
        return Long.valueOf(askForString());
    }
}