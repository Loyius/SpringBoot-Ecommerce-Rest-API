package com.loyius.course.resources;

import com.loyius.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @GetMapping
    public ResponseEntity<User> getUser() {
        User user = new User(1L, "Maria", "maria@gmail.com", "99999", "1234");
        return ResponseEntity.ok().body(user);
    }
}
