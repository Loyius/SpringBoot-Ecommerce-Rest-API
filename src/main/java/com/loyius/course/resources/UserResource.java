package com.loyius.course.resources;

import com.loyius.course.entities.User;
import com.loyius.course.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> list = service.getUsers();
        if (list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User obj = service.getUserById(id);
        if (obj == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insertNewUser(@RequestBody User obj) {
        obj = service.insertNewUser(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        //created() expects a header(location) with the URI to the added content
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        service.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User obj) {
        obj = service.updateUserById(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
