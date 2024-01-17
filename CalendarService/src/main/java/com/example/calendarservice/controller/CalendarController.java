package com.example.calendarservice.controller;

import com.example.calendarservice.model.Calendar;
import com.example.calendarservice.service.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("calendar")
public class CalendarController {

    @Autowired
    CalendarService calendarService;

    @GetMapping("getAllCalendars")
    public ResponseEntity<List<Calendar>> getAllCalendars(){
        return calendarService.getAllCalendars();
    }

    @PostMapping("create")
    public ResponseEntity<Integer> createCalendar(){
        return calendarService.createCalendar();
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteCalendar(@PathVariable int id){
        return calendarService.deleteCalendar(id);
    }

    @PostMapping("addAppointment/{id}/{appointmentId}")
    public ResponseEntity<String> addAppointment(@PathVariable int id, @PathVariable int appointmentId){
        return calendarService.addAppointment(id, appointmentId);
    }
}

