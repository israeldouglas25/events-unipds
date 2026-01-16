package br.com.israel.events.services;

import br.com.israel.events.domain.Session;
import br.com.israel.events.domain.Subscription;
import br.com.israel.events.domain.User;

import java.util.List;

public interface ISubscriptionService {

    public Subscription create(Subscription subscription);
    public List<Subscription> getAllByUser(User user);
    public List<Subscription> getAllBySession(Session session);
}
