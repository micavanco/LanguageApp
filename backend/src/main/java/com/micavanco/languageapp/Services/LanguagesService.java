package com.micavanco.languageapp.Services;

import com.micavanco.languageapp.Database.Languages;

import java.util.List;

public interface LanguagesService {
    List<Languages> getDataByLanguage(String language);
    Languages getElementByNum(String language, Integer questionNumber);
}