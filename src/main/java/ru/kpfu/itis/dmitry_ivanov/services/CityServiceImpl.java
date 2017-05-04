package ru.kpfu.itis.dmitry_ivanov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dmitry_ivanov.dao.CityDao;
import ru.kpfu.itis.dmitry_ivanov.model.City;

import java.util.List;

/**
 * Created by Dmitry on 03.05.2017.
 */

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public void addCity(City city) {
        if(cityDao.findByCityName(city.getCityName())==null) {
            cityDao.save(city);
        }
    }

    @Override
    public City getOneByName(String name) {
        return cityDao.findByCityName(name);
    }

    @Override
    public List<City> getAllCities() {
        return cityDao.findAll();
    }

    @Override
    public City findById(long id) {
        return cityDao.findById(id);
    }
}
