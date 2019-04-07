package com.micavanco.languageapp.Repositories;

import com.micavanco.languageapp.Database.User;

public interface UserDao {
    User findByUsername(String username);
    User save(User user);
}
