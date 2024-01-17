package com.example.appointmentservice.service;

import com.example.appointmentservice.dao.AppointmentDao;
import com.example.appointmentservice.feign.CalendarInterface;
import com.example.appointmentservice.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    AppointmentDao appointmentDao;

    @Autowired
    CalendarInterface calendarInterface;

    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return new ResponseEntity<>(appointmentDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> createAppointment(Appointment appointment, int calendarId) {
        calendarInterface.addAppointment(calendarId, appointmentDao.save(appointment).getId());
        return new ResponseEntity<>("Sucess", HttpStatus.CREATED);
    }

    public ResponseEntity<String> editAppointment(Appointment appointment, int id) {
        Optional<Appointment> appointmentFromDb = appointmentDao.findById(id);
        appointmentFromDb.get().setName(appointment.getName());
        appointmentFromDb.get().setDate(appointment.getDate());
        appointmentFromDb.get().setDescricao(appointment.getDescricao());
        appointmentDao.save(appointmentFromDb.get());
        return new ResponseEntity<>("Sucess", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAppointment(int id) {
        appointmentDao.delete(appointmentDao.findById(id).get());
        return new ResponseEntity<>("Sucess", HttpStatus.OK);
    }
}
