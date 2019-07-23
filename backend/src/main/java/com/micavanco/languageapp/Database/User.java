package com.micavanco.languageapp.Database;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

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

    //private List<Sessions> sessions;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "session_id")
    private Sessions session;

    @JsonFormat(pattern = "dd-mm-yyyy")
    @Column(name = "created_at")
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public User()
    {
        this.createdAt = new Date();
        //this.sessions = new ArrayList<>();
    }

    public User(Long id,
                String username,
                String password,
                String name,
                String surname,
                String city
    )
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.createdAt = new Date();
        //this.sessions = new ArrayList<>();
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

//    public List<Sessions> getSessions() {
//        return sessions;
//    }
//
//    public void setSessions(List<Sessions> sessions) {
//        this.sessions = sessions;
//    }


    public Sessions getSession() {
        return session;
    }

    public void setSession(Sessions session) {
        this.session = session;
    }
}
