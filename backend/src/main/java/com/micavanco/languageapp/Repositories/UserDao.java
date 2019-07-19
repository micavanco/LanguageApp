package com.micavanco.languageapp.Repositories;

import com.micavanco.languageapp.Database.User;

public interface UserDao {
    User findByUsername(String username);
    boolean addUser(User user);
    boolean deleteUser(User user);
}
