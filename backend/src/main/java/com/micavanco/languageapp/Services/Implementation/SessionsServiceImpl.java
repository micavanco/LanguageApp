package com.micavanco.languageapp.Services.Implementation;

import com.micavanco.languageapp.Database.Sessions;
import com.micavanco.languageapp.Repositories.SessionsDAO;
import com.micavanco.languageapp.Services.SessionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionsServiceImpl implements SessionsService {

    private SessionsDAO sessionsDAO;

    @Autowired
    public SessionsServiceImpl(SessionsDAO sessionsDAO) {
        this.sessionsDAO = sessionsDAO;
    }

    @Override
    public Sessions getSessionById(Long user_id) {
        return sessionsDAO.getByUser_id(user_id);
    }
}
