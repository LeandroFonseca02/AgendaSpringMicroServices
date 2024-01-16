package com.example.calendarservice.dao;

import com.example.calendarservice.model.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarDao extends JpaRepository<Calendar, Integer> {
}
