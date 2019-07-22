package com.micavanco.languageapp.Services.Implementation;

import com.micavanco.languageapp.Database.Languages;
import com.micavanco.languageapp.Repositories.LanguagesDAO;
import com.micavanco.languageapp.Services.LanguagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LanguagesServiceImpl implements LanguagesService {

    private LanguagesDAO languagesDAO;

    @Autowired
    public LanguagesServiceImpl(LanguagesDAO languagesDAO) {
        this.languagesDAO = languagesDAO;
    }

    @Override
    public List<Languages> getDataByLanguage(String language) {
        return languagesDAO.findAllByLanguage(language);
    }

    @Override
    public Languages getElementByNum(String language, Integer questionNumber) {
        return languagesDAO.findByQuestionNumberAndLanguage(questionNumber, language);
    }
}
