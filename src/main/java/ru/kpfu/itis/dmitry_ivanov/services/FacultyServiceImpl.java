package ru.kpfu.itis.dmitry_ivanov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dmitry_ivanov.dao.FacultyDao;
import ru.kpfu.itis.dmitry_ivanov.model.Faculty;

/**
 * Created by Dmitry on 03.05.2017.
 */

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyDao facultyDao;

    @Override
    public void addFaculty(Faculty faculty) {
        if(facultyDao.findByName(faculty.getName())==null) {
            faculty.setId(12L);
            facultyDao.save(faculty);
        }
    }

    @Override
    public Faculty findByFacultyName(String name) {
        return facultyDao.findByName(name);
    }

    @Override
    public Faculty findFacultyById(Long id) {
        return facultyDao.findById(id);
    }
}
