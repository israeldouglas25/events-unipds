package br.com.israel.events.controllers;

import br.com.israel.events.domain.User;
import br.com.israel.events.services.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping
    public ResponseEntity<User> create(@Valid @RequestBody User user, UriComponentsBuilder uriBuilder) {
        var createdUser = iUserService.create(user);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(createdUser.getIdUser()).toUri();
        return ResponseEntity.created(uri).body(iUserService.create(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(iUserService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(iUserService.getById(id));
    }

    @GetMapping("email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(iUserService.getByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User updateUser) {
        User user = iUserService.getById(id);
        return ResponseEntity.ok(iUserService.update(user, updateUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        iUserService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
