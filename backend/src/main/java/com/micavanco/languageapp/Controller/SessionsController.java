package com.micavanco.languageapp.Controller;

import com.micavanco.languageapp.Database.Languages;
import com.micavanco.languageapp.Database.Sessions;
import com.micavanco.languageapp.Services.SessionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/sessions")
public class SessionsController {

    private SessionsService sessionsService;

    @Autowired
    public SessionsController(SessionsService sessionsService) {
        this.sessionsService = sessionsService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Sessions> saveSession(@RequestParam("session_id")String session_id,
                                                @RequestParam("user_id")String user_id,
                                                @RequestParam("lang_id")String lang_id,
                                                @RequestParam("points")String points)
    {
        boolean session;
        try {
            session = sessionsService.saveSession(new Long(session_id), new Long(user_id), new Long(lang_id), new Long(points));
        }catch (Exception ex)
        {
            return new ResponseEntity<Sessions>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return session ? new ResponseEntity<Sessions>(HttpStatus.OK):
                new ResponseEntity<Sessions>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<Sessions> saveSession(@RequestParam("user_id")String user_id)
    {
        Sessions session;
        try {
            session = sessionsService.getSessionById(new Long(user_id));
        }catch (Exception ex)
        {
            return new ResponseEntity<Sessions>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return session != null ? new ResponseEntity<Sessions>(session, HttpStatus.OK):
                new ResponseEntity<Sessions>(HttpStatus.BAD_REQUEST);
    }
}
