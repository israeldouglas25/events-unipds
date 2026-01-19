package br.com.israel.events.services.session;

import br.com.israel.events.domain.Session;
import br.com.israel.events.exceptions.NotFoundException;
import br.com.israel.events.interfaces.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService implements ISessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public Session create(Session session) {
        return sessionRepository.save(session);
    }

    @Override
    public Session getById(Integer id) {
        return sessionRepository.findById(id).orElseThrow(() -> new NotFoundException("Session not found: " + id));
    }

    @Override
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session update(Session session, Session updateSession) {
        if (updateSession.getTitle() != null) {
            session.setTitle(updateSession.getTitle());
        }
        if (updateSession.getStartDate() != null) {
            session.setStartDate(updateSession.getStartDate());
        }
        if (updateSession.getStartTime() != null) {
            session.setStartTime(updateSession.getStartTime());
        }
        if (updateSession.getConference() != null) {
            session.setConference(updateSession.getConference());
        }
        return sessionRepository.save(session);
    }

    @Override
    public void delete(Integer id) {
        Session session = getById(id);
        sessionRepository.delete(session);
    }
}
