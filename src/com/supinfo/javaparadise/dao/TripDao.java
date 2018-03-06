package com.supinfo.javaparadise.dao;

import com.supinfo.javaparadise.entities.Trip;

public interface TripDao
{
    long createTrip(Trip t);

    Trip findTripById(long id);

    boolean removeTrip(Trip t);
}
