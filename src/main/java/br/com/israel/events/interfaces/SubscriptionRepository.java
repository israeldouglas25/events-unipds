package br.com.israel.events.interfaces;

import br.com.israel.events.domain.Subscription;
import br.com.israel.events.domain.SubscriptionID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionID> {
}
