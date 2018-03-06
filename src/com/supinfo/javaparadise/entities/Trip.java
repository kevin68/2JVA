package com.supinfo.javaparadise.entities;

import java.math.BigDecimal;

public class Trip
{
    private long id;
    private Place departure;
    private Place destination;
    private BigDecimal price;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public Place getDeparture()
    {
        return departure;
    }

    public void setDeparture(Place departure)
    {
        this.departure = departure;
    }

    public Place getDestination()
    {
        return destination;
    }

    public void setDestination(Place destination)
    {
        this.destination = destination;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }
}