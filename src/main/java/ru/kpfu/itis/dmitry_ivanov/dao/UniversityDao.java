package ru.kpfu.itis.dmitry_ivanov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.dmitry_ivanov.model.University;

import java.util.List;

/**
 * Created by Dmitry on 03.05.2017.
 */
public interface UniversityDao extends JpaRepository<University, Long> {

    University findByUniversityName(String name);

    University findById(Long id);
}
