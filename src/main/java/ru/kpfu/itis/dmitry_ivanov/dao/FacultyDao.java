package ru.kpfu.itis.dmitry_ivanov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.dmitry_ivanov.model.Faculty;

/**
 * Created by Dmitry on 03.05.2017.
 */
public interface FacultyDao extends JpaRepository<Faculty, Long> {

    Faculty findByName(String name);

    Faculty findById(Long id);

}
