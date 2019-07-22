package com.micavanco.languageapp.Services;

import com.micavanco.languageapp.Database.Sessions;

public interface SessionsService {
    Sessions getSessionById(Long user_id);
}
