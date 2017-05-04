package ru.kpfu.itis.dmitry_ivanov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dmitry_ivanov.dao.ProfessorDao;
import ru.kpfu.itis.dmitry_ivanov.model.Professor;

/**
 * Created by Dmitry on 03.05.2017.
 */

@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorDao professorDao;

    @Override
    public Professor findProfessorById(Long id) {
        return professorDao.findById(id);
    }

    @Override
    public void addProfessor(Professor professor) {
        if(professorDao.findByFio(professor.getFio())==null){
            professor.setId(12L);
            professorDao.save(professor);
        }
    }

    @Override
    public Professor findProfessorByFio(String professorName) {
        return professorDao.findByFio(professorName);
    }
}
