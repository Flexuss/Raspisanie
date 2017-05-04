package ru.kpfu.itis.dmitry_ivanov.services;

import ru.kpfu.itis.dmitry_ivanov.model.City;

import java.util.List;

/**
 * Created by Dmitry on 03.05.2017.
 */
public interface CityService {

    void addCity(City city);

    City getOneByName(String name);

    List<City> getAllCities();

    City findById(long id);
}
