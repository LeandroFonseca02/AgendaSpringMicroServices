package com.example.userservice.service;

import com.example.userservice.dao.UserDao;
import com.example.userservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
    }
}
