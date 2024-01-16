package com.example.userservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("CALENDAR-SERVICE")
public interface CalendarInterface {
    @PostMapping("calendar/create")
    public ResponseEntity<Integer> createCalendar();
}
