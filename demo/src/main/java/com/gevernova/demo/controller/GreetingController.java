package com.gevernova.demo.controller;

import com.gevernova.demo.entity.Greeting;
import com.gevernova.demo.repository.GreetingRepository;
import com.gevernova.demo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    private GreetingService service;

    @Autowired
    private GreetingRepository repository;

    // UC 1: Return messages for HTTP Methods
    @GetMapping
    public String getGreeting() {
        return "GET: Hello World";
    }

    @PostMapping
    public String postGreeting() {
        return "POST: Hello World";
    }

    @PutMapping
    public String putGreeting() {
        return "PUT: Hello World";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "DELETE: Hello World";
    }

    // UC 2: Basic service layer message
    @GetMapping("/message")
    public String getGreetingMessage() {
        return service.getGreetingMessage();
    }

    // UC 3: Personalized greeting
    @GetMapping("/custom")
    public String getCustomGreeting(@RequestParam(required = false) String firstName,
                                    @RequestParam(required = false) String lastName) {
        return service.getPersonalGreeting(firstName, lastName);
    }

    // UC 4: Save greeting
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return repository.save(greeting);
    }

    // UC 5: Find greeting by ID
    @GetMapping("/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UC 6: List all greetings
    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return repository.findAll();
    }

    // UC 7: Edit greeting
    @PutMapping("/{id}")
    public ResponseEntity<Greeting> updateGreeting(@PathVariable Long id, @RequestBody Greeting newGreeting) {
        return repository.findById(id).map(g -> {
            g.setMessage(newGreeting.getMessage());
            return ResponseEntity.ok(repository.save(g));
        }).orElse(ResponseEntity.notFound().build());
    }

    // UC 8: Delete greeting
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteGreeting(@PathVariable Long id) {
        return repository.findById(id).map(g -> {
            repository.delete(g);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

