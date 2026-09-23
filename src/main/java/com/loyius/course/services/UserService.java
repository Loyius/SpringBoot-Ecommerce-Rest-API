package com.loyius.course.services;

import com.loyius.course.entities.User;
import com.loyius.course.repositories.UserRepository;
import com.loyius.course.services.exceptions.DatabaseException;
import com.loyius.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public void deleteUserById(Long id){
        try{
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            //for me to find the type of exception being thrown we can use:
            //catch(RuntimeException e){ e.printStackTrace();}
            throw new ResourceNotFoundException(id);
        } catch(DataIntegrityViolationException e){ throw new DatabaseException(e.getMessage());
        }
    }

    public User updateUserById(Long id, User user){
        //Prepare the monitored object to update and then post it in the db
       try{ User entity  = repository.getReferenceById(id);
        updateData(entity,user);
        return repository.save(entity);}
       catch(EntityNotFoundException e){ throw new ResourceNotFoundException(id); }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }

}
