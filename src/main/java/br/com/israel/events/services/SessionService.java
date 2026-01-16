package br.com.israel.events.services;

import br.com.israel.events.domain.Session;
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
        return sessionRepository.findById(id).orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
    }

    @Override
    public List<Session> getAll() {
        return sessionRepository.findAll();
    }

    @Override
    public Session update(Session session) {
        Session newSession = getById(session.getIdSession());
        newSession.setTitle(session.getTitle());
        newSession.setStartDate(session.getStartDate());
        newSession.setStartTime(session.getStartTime());
        newSession.setConference(session.getConference());
        return sessionRepository.save(newSession);
    }

    @Override
    public void delete(Integer id) {
        Session session = getById(id);
        sessionRepository.delete(session);
    }
}
