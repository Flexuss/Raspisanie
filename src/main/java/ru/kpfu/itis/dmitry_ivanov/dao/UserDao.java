package ru.kpfu.itis.dmitry_ivanov.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.dmitry_ivanov.model.User;

/**
 * Created by Dmitry on 30.04.2017.
 */
public interface UserDao extends JpaRepository<User, Long> {
    User findByLogin(String username);
}
