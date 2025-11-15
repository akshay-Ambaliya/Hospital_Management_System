package com.example.HMS.repositories;

import com.example.HMS.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepo extends JpaRepository<Appointment,Long> {

}
