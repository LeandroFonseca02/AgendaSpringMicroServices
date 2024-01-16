package com.example.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("CONTACTBOOK-SERVICE")
public interface ContactBookInterface {
    @PostMapping("contactbook/create")
    public ResponseEntity<Integer> createContactBook();

    @PostMapping("contactbook/delete/{id}")
    public ResponseEntity<String> deleteContactBook(@PathVariable Integer id);
}
