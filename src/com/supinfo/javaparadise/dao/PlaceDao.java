package com.supinfo.javaparadise.dao;

import com.supinfo.javaparadise.entities.Place;

public interface PlaceDao
{
    long createPlace(Place p);

    Place findPlaceById(long id);

    boolean updatePlace(Place p);

    boolean removePlace(Place p);
}
