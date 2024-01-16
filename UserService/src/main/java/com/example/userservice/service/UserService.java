package com.example.userservice.service;

import com.example.userservice.dao.UserDao;
import com.example.userservice.feign.UserInterface;
import com.example.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserInterface userInterface;

    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> createUser(User user) {
        user.setContactBookId(userInterface.createContactBook().getBody());
        userDao.save(user);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> editUser(User user, Integer id) {
        Optional<User> userFromDb = userDao.findById(id);
        userFromDb.get().setName(user.getName());
        userFromDb.get().setEmail(user.getEmail());
        userDao.save(userFromDb.get());
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteUser(Integer id) {
        Optional<User> userFromDb = userDao.findById(id);
        userInterface.deleteContactBook(userFromDb.get().getContactBookId());
        userDao.delete(userFromDb.get());
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
