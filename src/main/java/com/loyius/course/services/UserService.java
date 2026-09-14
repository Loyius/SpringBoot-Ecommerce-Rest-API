package com.loyius.course.services;

import com.loyius.course.entities.User;
import com.loyius.course.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }
}
