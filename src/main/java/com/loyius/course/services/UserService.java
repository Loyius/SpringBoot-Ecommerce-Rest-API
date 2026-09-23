package com.loyius.course.services;

import com.loyius.course.entities.User;
import com.loyius.course.repositories.UserRepository;
import com.loyius.course.services.exceptions.ResourceNotFoundException;
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
        //gets the object directly from the db
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(()-> new ResourceNotFoundException(id));
    }

    public User insertNewUser(User user){ return repository.save(user); }

    public void deleteUserById(Long id){ repository.deleteById(id); }

    public User updateUserById(Long id, User user){
        //Prepare the monitored object to update and then post it in the db
        User entity  = repository.getReferenceById(id);
        updateData(entity,user);
        return repository.save(entity);
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

}
