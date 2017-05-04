package ru.kpfu.itis.dmitry_ivanov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.dmitry_ivanov.dao.RoleDao;
import ru.kpfu.itis.dmitry_ivanov.dao.UserDao;
import ru.kpfu.itis.dmitry_ivanov.model.Role;
import ru.kpfu.itis.dmitry_ivanov.model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dmitry on 30.04.2017.
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void save(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L));
        user.setRoles(roles);
        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByLogin(username);
    }
}
