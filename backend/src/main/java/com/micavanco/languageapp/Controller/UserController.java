package com.micavanco.languageapp.Controller;

import com.micavanco.languageapp.Database.User;
import com.micavanco.languageapp.Repositories.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class UserController {

    private final UserDao userRepository;

    public UserController(UserDao userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String handleUser(Model model)
    {
        model.addAttribute("user", new User());
        model.addAttribute("error", false);


        return "login";
    }

    @PostMapping
    public String login(@Valid User user, Errors errors, Model model)
    {
        User user_temp = userRepository.findByUsername(user.getUsername());
        if(user_temp == null)
        {
            model.addAttribute("error", true);
            return "/login";
        }

        if(!user_temp.getPassword().equals(user.getPassword()))
        {
            model.addAttribute("error", true);
            return "/login";
        }

        System.out.println("Username: "+user_temp.getUsername()+"\nPassword: "+user_temp.getPassword());

        return "redirect:/";
    }
}
