package ru.kpfu.itis.dmitry_ivanov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dmitry_ivanov.dao.UniversityDao;
import ru.kpfu.itis.dmitry_ivanov.model.University;

import java.util.List;

/**
 * Created by Dmitry on 03.05.2017.
 */

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityDao universityDao;

    @Override
    public University findByUniversityName(String name) {
        return universityDao.findByUniversityName(name);
    }

    @Override
    public void addUniversity(University university) {
        if(universityDao.findByUniversityName(university.getUniversityName())==null) {
            university.setId(12L);
            universityDao.save(university);
        }
    }

    @Override
    public University findById(Long id) {
        return universityDao.findById(id);
    }
}
