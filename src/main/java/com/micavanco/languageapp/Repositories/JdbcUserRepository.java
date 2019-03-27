package com.micavanco.languageapp.Repositories;

import com.micavanco.languageapp.Database.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcUserRepository implements UserRepository {


    private JdbcTemplate jdbc;

    @Autowired
    public JdbcUserRepository(JdbcTemplate jdbc)
    {
        this.jdbc = jdbc;
    }

    @Override
    public User findByUsername(String username) {
        return jdbc.queryForObject("select id, username, password, name, surname, city from User where username=?",
                this::mapRowToUser, username);
    }

    @Override
    public User save(User user) {
         jdbc.update("insert into USER(id, username, password, name, surname, city, createdAt) values (?, ?, ?, ?, ?, ?, ?)",
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getCity(),
                user.getCreatedAt());
         return user;
    }

    private User mapRowToUser(ResultSet resultSet, int RowNumber) throws SQLException
    {
        return new User(new Long(resultSet.getString("id")),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("name"),
                resultSet.getString("surname"),
                resultSet.getString("city"));
    }
}
