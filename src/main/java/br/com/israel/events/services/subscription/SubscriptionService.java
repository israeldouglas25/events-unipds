package br.com.israel.events.services.subscription;

import br.com.israel.events.domain.Session;
import br.com.israel.events.domain.Subscription;
import br.com.israel.events.domain.User;
import br.com.israel.events.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class SubscriptionService implements ISubscriptionService{

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    @Transactional
    public Subscription create(Subscription subscription) {
        subscription.setCreatedAt(LocalDateTime.now());
        subscription.setUniqueID(UUID.randomUUID().toString());
        return subscriptionRepository.save(subscription);
    }

    @Override
    public List<Subscription> getAllByUser(User user) {
        return subscriptionRepository.findByIdUser(user);
    }

    @Override
    public List<Subscription> getAllBySession(Session session) {
        return subscriptionRepository.findByIdSession(session);
    }
}
