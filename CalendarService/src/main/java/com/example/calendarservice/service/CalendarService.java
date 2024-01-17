package com.example.calendarservice.service;

import com.example.calendarservice.dao.CalendarDao;
import com.example.calendarservice.model.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {
    @Autowired
    CalendarDao calendarDao;
    public ResponseEntity<List<Calendar>> getAllCalendars() {
        return new ResponseEntity<>(calendarDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Integer> createCalendar() {
        return new ResponseEntity<>(calendarDao.save(new Calendar()).getId(), HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteCalendar(int id) {
        calendarDao.delete(calendarDao.findById(id).get());
        return new ResponseEntity<>("Sucess", HttpStatus.OK);
    }

    public ResponseEntity<String> addAppointment(int id, int appointmentId) {
        Optional<Calendar> calendar = calendarDao.findById(id);
        calendar.get().getAppointmentList().add(appointmentId);
        calendarDao.save(calendar.get());
        return new ResponseEntity<>("Sucess", HttpStatus.OK);
    }
}
