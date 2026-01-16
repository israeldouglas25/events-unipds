package br.com.israel.events.controllers;

import br.com.israel.events.domain.Session;
import br.com.israel.events.domain.Subscription;
import br.com.israel.events.domain.User;
import br.com.israel.events.services.subscription.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Autowired
    private ISubscriptionService iSubscriptionService;

    @PostMapping
    public ResponseEntity<Subscription> createSubscription(@RequestBody Subscription subscription) {
        return ResponseEntity.ok(iSubscriptionService.create(subscription));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Subscription>> getByUserId(@PathVariable Integer id) {
        User user = new User();
        user.setUserId(id);
        return ResponseEntity.ok(iSubscriptionService.getAllByUser(user));
    }

    @GetMapping("/session/{id}")
    public ResponseEntity<List<Subscription>> getBySessionId(@PathVariable Integer id) {
        Session session = new Session();
        session.setIdSession(id);
        return ResponseEntity.ok(iSubscriptionService.getAllBySession(session));
    }

}
