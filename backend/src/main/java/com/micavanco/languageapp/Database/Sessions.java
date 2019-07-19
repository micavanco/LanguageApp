package com.micavanco.languageapp.Database;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sessions {

    @Id
    private Long session_id;

    private Long user_id;

    private Long lang_id;

    private Long points;

    public Sessions(){}

    public Sessions(Long session_id, Long user_id, Long lang_id, Long points) {
        this.session_id = session_id;
        this.user_id = user_id;
        this.lang_id = lang_id;
        this.points = points;
    }

    public Long getSession_id() {
        return session_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getLang_id() {
        return lang_id;
    }

    public void setLang_id(Long lang_id) {
        this.lang_id = lang_id;
    }

    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }
}
