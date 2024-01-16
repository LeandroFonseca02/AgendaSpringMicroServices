package com.example.contactbookservice.dao;

import com.example.contactbookservice.model.ContactBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactBookDao extends JpaRepository<ContactBook, Integer> {
}
