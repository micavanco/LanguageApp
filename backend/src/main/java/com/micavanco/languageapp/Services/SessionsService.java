package com.micavanco.languageapp.Services;

import com.micavanco.languageapp.Database.Sessions;

public interface SessionsService {
    Sessions getSessionById(Long user_id);
    boolean saveSession(Long session_id, Long user_id, Long lang_id, Long points);
}
