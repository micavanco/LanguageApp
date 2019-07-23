package com.micavanco.languageapp.Services.Implementation;

import com.micavanco.languageapp.Database.Sessions;
import com.micavanco.languageapp.Database.User;
import com.micavanco.languageapp.Repositories.SessionsDAO;
import com.micavanco.languageapp.Repositories.UserDao;
import com.micavanco.languageapp.Services.SessionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionsServiceImpl implements SessionsService {

    private SessionsDAO sessionsDAO;
    private UserDao userDao;

    @Autowired
    public SessionsServiceImpl(SessionsDAO sessionsDAO, UserDao userDao) {
        this.sessionsDAO = sessionsDAO;
        this.userDao = userDao;
    }

    @Override
    public Sessions getSessionById(Long user_id) {
        return sessionsDAO.getByUser_id(user_id);
    }

    @Override
    public boolean saveSession(Long session_id, Long user_id, Long lang_id, Long points) {

        Sessions session = new Sessions();
        session.setLang_id(lang_id);
        session.setUser_id(user_id);
        session.setPoints(points);
        session.setSession_id(session_id);

        User user = userDao.getUserById(user_id);

        if(user == null)
            return false;

        user.setSession(session);

        userDao.addUser(user);

        return true;
    }
}
