package com.micavanco.languageapp.Controller;

import com.micavanco.languageapp.Database.User;
import com.micavanco.languageapp.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestParam(value = "username")String username,
                                     @RequestParam(value = "password")String password,
                                     @RequestParam(value = "name")String name,
                                     @RequestParam(value = "surname")String surname,
                                     @RequestParam(value = "city")String city)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setCity(city);

        boolean wasCreated = false;

        try {
            wasCreated = userService.createUser(user);
        }catch (Exception ex)
        {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return wasCreated ? new ResponseEntity<User>(user,HttpStatus.CREATED):
                new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<User> removeUser(@RequestParam(value = "username")String username,
                                           @RequestParam(value = "password")String password)
    {
        User user;
        boolean wasDeleted = false;
        try {
            user = userService.getUserByUsername(username);
            if(user != null && user.getPassword().equals(password))
                wasDeleted = userService.removeUser(user);
        }catch (Exception ex)
        {
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return wasDeleted ? new ResponseEntity<User>(user,HttpStatus.OK):
                new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }
}
