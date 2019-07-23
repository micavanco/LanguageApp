package com.micavanco.languageapp.Controller;

import com.micavanco.languageapp.Database.Languages;
import com.micavanco.languageapp.Database.User;
import com.micavanco.languageapp.Services.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/languages")
public class LanguagesController {

    private LanguagesService languagesService;

    @Autowired
    public LanguagesController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<Languages> getQuestion(@RequestParam("language")String language, @RequestParam("number")String number)
    {
        Languages question;
        try {
            question = languagesService.getElementByNum(language, new Integer(number));
        }catch (Exception ex)
        {
            return new ResponseEntity<Languages>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return question != null ? new ResponseEntity<Languages>(question, HttpStatus.OK):
                new ResponseEntity<Languages>(HttpStatus.BAD_REQUEST);
    }
}
