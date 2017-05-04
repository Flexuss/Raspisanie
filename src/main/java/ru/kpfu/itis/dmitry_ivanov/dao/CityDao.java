package ru.kpfu.itis.dmitry_ivanov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.dmitry_ivanov.model.City;

import java.util.List;

/**
 * Created by Dmitry on 03.05.2017.
 */
public interface CityDao extends JpaRepository<City, Long> {

    List<City> findAll();

    City findByCityName(String name);

    City findById(Long id);
}
