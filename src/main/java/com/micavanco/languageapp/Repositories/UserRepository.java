package com.micavanco.languageapp.Repositories;

import com.micavanco.languageapp.Database.User;

public interface UserRepository {

    User findByUsername(String username);

    User save(User user);
}
