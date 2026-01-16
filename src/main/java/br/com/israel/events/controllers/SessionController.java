package br.com.israel.events.controllers;

import br.com.israel.events.domain.Session;
import br.com.israel.events.services.session.ISessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private ISessionService iSessionService;

    @PostMapping
    public ResponseEntity<Session> create(@RequestBody Session session) {
        return ResponseEntity.ok(iSessionService.create(session));
    }

    @GetMapping
    public ResponseEntity<List<Session>> getAll() {
        return ResponseEntity.ok(iSessionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Integer id) {
        return ResponseEntity.ok(iSessionService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> update(@PathVariable Integer id) {
        Session session = iSessionService.getById(id);
        return ResponseEntity.ok(iSessionService.update(session));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        iSessionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
