package com.micavanco.languageapp.Database;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Languages {

    @Id
    private Long lang_id;

    private String question;

    private String answer;

    private String language;

    private Integer questionNumber;


    public Languages(){}

    public Languages(String question, String answer, String language, Integer questionNumber) {
        this.question = question;
        this.answer = answer;
        this.language = language;
        this.questionNumber = questionNumber;
    }

    public Long getLang_id() {
        return lang_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }
}
