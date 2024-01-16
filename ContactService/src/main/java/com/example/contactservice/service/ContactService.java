package com.example.contactservice.service;

import com.example.contactservice.dao.ContactDao;
import com.example.contactservice.feign.ContactBookInterface;
import com.example.contactservice.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactDao contactDao;
    @Autowired
    ContactBookInterface contactBookInterface;

    public ResponseEntity<List<Contact>> getAllContacts() {
        return new ResponseEntity<>(contactDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> createContact(Contact contact, int contactBookId) {
        contactBookInterface.addContact(contactBookId, contactDao.save(contact).getId());
        return new ResponseEntity<>("Sucess", HttpStatus.CREATED);
    }

    public ResponseEntity<String> editContact(Contact contact, int id) {
        Optional<Contact> contactFromDb = contactDao.findById(id);
        contactFromDb.get().setName(contact.getName());
        contactFromDb.get().setEmail(contact.getEmail());
        contactFromDb.get().setPhoneNumber(contact.getPhoneNumber());
        contactDao.save(contactFromDb.get());
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteContact(int id) {
        Optional<Contact> contactFromDb = contactDao.findById(id);
        contactDao.delete(contactFromDb.get());
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
