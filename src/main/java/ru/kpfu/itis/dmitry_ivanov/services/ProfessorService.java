package ru.kpfu.itis.dmitry_ivanov.services;

import ru.kpfu.itis.dmitry_ivanov.model.Professor;

/**
 * Created by Dmitry on 03.05.2017.
 */
public interface ProfessorService {

    Professor findProfessorById(Long id);

    void addProfessor(Professor professor);

    Professor findProfessorByFio(String professorName);
}
