package com.example.userservice.service;

import com.example.userservice.dao.UserDao;
import com.example.userservice.feign.CalendarInterface;
import com.example.userservice.feign.ContactBookInterface;
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
    ContactBookInterface contactBookInterface;

    @Autowired
    CalendarInterface calendarInterface;

    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> createUser(User user) {
        user.setContactBookId(contactBookInterface.createContactBook().getBody());
        user.setCalendarId(calendarInterface.createCalendar().getBody());
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
        contactBookInterface.deleteContactBook(userFromDb.get().getContactBookId());
        userDao.delete(userFromDb.get());
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
