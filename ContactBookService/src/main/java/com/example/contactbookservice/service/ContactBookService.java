package com.example.contactbookservice.service;

import com.example.contactbookservice.dao.ContactBookDao;
import com.example.contactbookservice.model.ContactBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactBookService {

    @Autowired
    ContactBookDao contactBookDao;

    public ResponseEntity<List<ContactBook>> getAllContactBooks() {
        return new ResponseEntity<>(contactBookDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Integer> createContactBook() {
        ContactBook contactBook = new ContactBook();
        contactBookDao.save(contactBook);
        return new ResponseEntity<>(contactBook.getId(), HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteContactBook(Integer id) {
        Optional<ContactBook> contactBook = contactBookDao.findById(id);
        contactBookDao.delete(contactBook.get());
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> addContact(Integer id, Integer contactId) {
        Optional<ContactBook> contactBook = contactBookDao.findById(id);
        List<Integer> contactList = contactBook.get().getContactIdsList();
        contactList.add(contactId);
        contactBookDao.save(contactBook.get());
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
