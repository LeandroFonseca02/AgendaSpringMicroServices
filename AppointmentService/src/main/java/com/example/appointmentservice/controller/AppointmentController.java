package com.example.appointmentservice.controller;

import com.example.appointmentservice.model.Appointment;
import com.example.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("getAllAppointments")
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @PostMapping("create/{calendarId}")
    public ResponseEntity<String> createAppointment(@RequestBody Appointment appointment, @PathVariable int calendarId){
        return appointmentService.createAppointment(appointment, calendarId);
    }

    @PostMapping("edit/{id}")
    public ResponseEntity<String> editAppointment(@RequestBody Appointment appointment, @PathVariable int id){
        return  appointmentService.editAppointment(appointment, id);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int id){
        return appointmentService.deleteAppointment(id);
    }
}
