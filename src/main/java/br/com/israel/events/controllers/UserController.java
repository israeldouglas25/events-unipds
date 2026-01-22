package br.com.israel.events.controllers;

import br.com.israel.events.domain.User;
import br.com.israel.events.domain.dto.UserDetailsResponse;
import br.com.israel.events.services.user.IUserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping
    public ResponseEntity<UserDetailsResponse> create(@Valid @RequestBody User user, UriComponentsBuilder uriBuilder) {
        var createdUser = iUserService.create(user);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(createdUser.idUser()).toUri();
        return ResponseEntity.created(uri).body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDetailsResponse>> getAll() {
        return ResponseEntity.ok(iUserService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsResponse> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(iUserService.getById(id));
    }

    @GetMapping("email/{email}")
    public ResponseEntity<UserDetailsResponse> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(iUserService.getByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetailsResponse> update(@PathVariable Integer id, @RequestBody User updateUser) {
        return ResponseEntity.ok(iUserService.update(id, updateUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        iUserService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
