package com.example.userservice.controller;

import com.example.userservice.model.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("create")
    public ResponseEntity<String> createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<String> editUser(@RequestBody User user, @PathVariable Integer id){
        return userService.editUser(user, id);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id){
        return userService.deleteUser(id);
    }

}
