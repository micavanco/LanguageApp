package com.micavanco.languageapp.Controller;

import com.micavanco.languageapp.Database.Language;
import com.micavanco.languageapp.Database.Language.Type;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/language")
public class LanguageController {

    @GetMapping
    public String getLanguageList(Model model)
    {
        List<Language> languages = Arrays.asList(
                new Language("DE", "German", Language.Type.German),
                new Language("ES", "Spanish", Language.Type.Spanish),
                new Language("NO", "Norwegian", Language.Type.Norwegian)
        );

        Type[] types = Language.Type.values();
        for(Type type : types)
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(languages, type));
            model.addAttribute("languages", languages);

        model.addAttribute("language", new Language("DE", "German", Language.Type.German));

        return "language";
    }

    @PostMapping
    public String handleLanguage(Language language)
    {
        System.out.println(language.getName());

        return "redirect:/";
    }


    private List<Language> filterByType(List<Language> languages, Type type) {
        return languages.stream()
                .filter(x -> x.getType().equals(type))
            .collect(Collectors.toList());
    }
}
