package ru.kpfu.itis.dmitry_ivanov.services;

import ru.kpfu.itis.dmitry_ivanov.model.Faculty;

/**
 * Created by Dmitry on 03.05.2017.
 */
public interface FacultyService {

    void addFaculty(Faculty faculty);

    Faculty findByFacultyName(String name);

    Faculty findFacultyById(Long id);

}
