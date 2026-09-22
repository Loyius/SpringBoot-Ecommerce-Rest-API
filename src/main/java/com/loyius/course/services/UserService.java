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
        //gets the object directly from the db
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public User insertNewUser(User obj){ return repository.save(obj); }

    public void deleteUserById(Long id){ repository.deleteById(id); }

    public User updateUserById(Long id, User obj){
        //Prepare the monitored object to update and then post it in the db
        User entity  = repository.getReferenceById(id);
        updateData(entity,obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
