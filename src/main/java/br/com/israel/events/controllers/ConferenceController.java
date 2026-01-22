package br.com.israel.events.controllers;

import br.com.israel.events.domain.Conference;
import br.com.israel.events.services.conference.IConferenceService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/conferences")
@SecurityRequirement(name = "bearer-key")
public class ConferenceController {

    @Autowired
    private IConferenceService iConferenceService;

    @PostMapping
    public ResponseEntity<Conference> create(@RequestBody Conference conference) {
        return ResponseEntity.ok(iConferenceService.create(conference));
    }

    @GetMapping
    public ResponseEntity<List<Conference>> getAll() {
        return ResponseEntity.ok(iConferenceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable Integer id) {
        return ResponseEntity.ok(iConferenceService.getById(id));
    }

}
