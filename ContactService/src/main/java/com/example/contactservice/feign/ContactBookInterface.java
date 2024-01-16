package com.example.contactservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("CONTACTBOOK-SERVICE")
public interface ContactBookInterface {
    @PostMapping("contactbook/addContact/{id}/{contactId}")
    public ResponseEntity<String> addContact(@PathVariable Integer id, @PathVariable Integer contactId);
}
