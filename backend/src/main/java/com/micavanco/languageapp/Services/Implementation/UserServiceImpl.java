package com.micavanco.languageapp.Services.Implementation;

import com.micavanco.languageapp.Controller.UserController;
import com.micavanco.languageapp.Database.User;
import com.micavanco.languageapp.Repositories.UserDao;
import com.micavanco.languageapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean createUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public boolean removeUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User loginUser(String username, String password) {

        User user = userDao.findByUsername(username);

        if(user == null || !user.getPassword().equals(password))
            return null;

        return user;
    }
}
