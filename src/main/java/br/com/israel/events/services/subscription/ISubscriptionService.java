package br.com.israel.events.services.subscription;

import br.com.israel.events.domain.Session;
import br.com.israel.events.domain.Subscription;
import br.com.israel.events.domain.User;

import java.util.List;

public interface ISubscriptionService {
    Subscription create(Subscription subscription);
    List<Subscription> getAllByUser(User user);
    List<Subscription> getAllBySession(Session session);
}
