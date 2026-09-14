package com.loyius.course.resources;

import com.loyius.course.entities.User;
import com.loyius.course.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUser() {
        List<User> list = service.getUsers();
        if (list.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        User obj = service.getUserById(id);
        if (obj == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(obj);
    }
}
