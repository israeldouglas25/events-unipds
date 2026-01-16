package br.com.israel.events.controllers;

import br.com.israel.events.domain.User;
import br.com.israel.events.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(iUserService.create(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(iUserService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(iUserService.getById(id));
    }

    @GetMapping("/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(iUserService.getByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id) {
        User user = iUserService.getById(id);
        return ResponseEntity.ok(iUserService.update(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        iUserService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
