package ru.kpfu.itis.dmitry_ivanov.services;

import ru.kpfu.itis.dmitry_ivanov.model.University;

import java.util.List;

/**
 * Created by Dmitry on 03.05.2017.
 */
public interface UniversityService {

    University findByUniversityName(String name);

    void addUniversity(University university);

    University findById(Long id);
}
