package com.micavanco.languageapp.Controller;

import com.micavanco.languageapp.Database.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserController {

    @GetMapping
    public String handleUser(Model model)
    {
        model.addAttribute("user", new User());

        return "login";
    }

    @PostMapping
    public String login(User user)
    {
        System.out.println("Username: "+user.getUsername()+"\nPassword: "+user.getPassword());

        return "redirect:/";
    }
}
