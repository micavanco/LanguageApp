package com.micavanco.languageapp.Database;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class User {

    @NotBlank(message = "Username can not be blank!")
    @Size(min = 4, message = "Username must be at least 4 characters long")
    private String username;
    @NotBlank(message = "Password can not be blank!")
    @Size(min = 6, message = "Password must contains at least 6 characters")
    @Pattern(regexp = ".*[0-9].*", message = "Must contains at least on digit")
    private String password;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Surname is required")
    private String surname;
    @NotBlank(message = "City is required")
    private String city;


    private Integer points;

    private Date createdAt;

    public User()
    {
        createdAt = new Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
