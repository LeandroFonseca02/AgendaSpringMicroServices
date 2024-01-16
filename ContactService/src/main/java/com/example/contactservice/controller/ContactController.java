package com.example.contactservice.controller;

import com.example.contactservice.model.Contact;
import com.example.contactservice.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("getAllContacts")
    public ResponseEntity<List<Contact>> getAllContacts(){
        return contactService.getAllContacts();
    }

    @PostMapping("create/{contactBookId}")
    public ResponseEntity<String> createContact(@RequestBody Contact contact, @PathVariable int contactBookId){
        return contactService.createContact(contact, contactBookId);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<String> editContact(@RequestBody Contact contact, @PathVariable int id){
        return contactService.editContact(contact, id);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id){
        return contactService.deleteContact(id);
    }

}
