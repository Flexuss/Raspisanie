package ru.kpfu.itis.dmitry_ivanov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.dmitry_ivanov.model.Professor;

/**
 * Created by Dmitry on 03.05.2017.
 */
public interface ProfessorDao extends JpaRepository<Professor, Long> {

    Professor findById(Long id);

    Professor findByFio(String fio);
}
