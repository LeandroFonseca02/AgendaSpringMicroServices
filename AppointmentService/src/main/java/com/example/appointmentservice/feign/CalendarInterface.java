package com.example.appointmentservice.feign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("CALENDAR-SERVICE")
public interface CalendarInterface {
    @PostMapping("calendar/addAppointment/{id}/{appointmentId}")
    public ResponseEntity<String> addAppointment(@PathVariable int id, @PathVariable int appointmentId);
}
