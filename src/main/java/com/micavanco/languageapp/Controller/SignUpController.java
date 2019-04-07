package com.micavanco.languageapp.Controller;

import com.micavanco.languageapp.Database.User;
import com.micavanco.languageapp.Repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private final UserDao userRepository;

    @Autowired
    public SignUpController(UserDao userRepository)
    {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String signUpForm(Model model)
    {
        model.addAttribute("user", new User());
        return "/signup";
    }

    @PostMapping
    public String createNewUser(@Valid User user, Errors errors)
    {
        if(errors.hasErrors())
            return "/signup";

        System.out.println("Username: "+ user.getUsername()+"\nPassword: "+user.getPassword()+"\nCreated at: "+user.getCreatedAt());
        userRepository.save(user);

        return "redirect:/";
    }
}
