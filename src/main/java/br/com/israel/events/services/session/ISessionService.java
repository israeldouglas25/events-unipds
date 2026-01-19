package br.com.israel.events.services.session;

import br.com.israel.events.domain.Session;

import java.util.List;

public interface ISessionService {
    Session create(Session session);
    Session getById(Integer id);
    List<Session> getAll();
    Session update(Session session, Session updateSession);
    void delete(Integer id);
}
