package com.example.contactbookservice.controller;

import com.example.contactbookservice.model.ContactBook;
import com.example.contactbookservice.service.ContactBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contactbook")
public class ContactBookController {

    @Autowired
    ContactBookService contactBookService;

    @GetMapping("getAllContactBooks")
    public ResponseEntity<List<ContactBook>> getALlContactBooks(){
        return contactBookService.getAllContactBooks();
    }

    @PostMapping("create")
    public ResponseEntity<Integer> createContactBook(){
        return contactBookService.createContactBook();
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteContactBook(@PathVariable Integer id){
        return contactBookService.deleteContactBook(id);
    }

}
