package ru.kpfu.itis.dmitry_ivanov.services;

/**
 * Created by Dmitry on 30.04.2017.
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
