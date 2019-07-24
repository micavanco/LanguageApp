package com.micavanco.languageapp.Services;

import com.micavanco.languageapp.Database.User;

public interface UserService {
    boolean createUser(User user);
    boolean removeUser(User user);
    User getUserByUsername(String username);
    User loginUser(String username, String password);
}
