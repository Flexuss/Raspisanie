package ru.kpfu.itis.dmitry_ivanov.services;

import ru.kpfu.itis.dmitry_ivanov.model.User;

/**
 * Created by Dmitry on 30.04.2017.
 */
public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
