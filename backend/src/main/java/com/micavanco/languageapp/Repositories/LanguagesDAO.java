package com.micavanco.languageapp.Repositories;

import com.micavanco.languageapp.Database.Languages;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LanguagesDAO extends CrudRepository<Languages, Long> {

    @Query("SELECT l FROM Languages l WHERE l.language=:language")
    List<Languages> findAllByLanguage(@Param("language") String language);

    Languages findByQuestionNumberAndLanguage(Integer questionNumber, String language);
}
