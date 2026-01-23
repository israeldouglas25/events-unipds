package br.com.israel.events.repositories;

import br.com.israel.events.domain.Session;
import br.com.israel.events.domain.Subscription;
import br.com.israel.events.domain.SubscriptionID;
import br.com.israel.events.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionID> {
    List<Subscription> findByIdUser(User user);
    List<Subscription> findByIdSession(Session session);
}
