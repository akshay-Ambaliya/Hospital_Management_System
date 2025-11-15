package com.example.HMS.services;

import com.example.HMS.Entities.Appointment;
import com.example.HMS.Entities.Doctor;
import com.example.HMS.repositories.AppointmentRepo;
import com.example.HMS.repositories.PatientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo repo;
    private static final Logger logger = LoggerFactory.getLogger(AppointmentService.class);
    public Page<Appointment> getAllAppointment(int page, int size){
        try {
            Pageable p = PageRequest.of(page,size);
            return repo.findAll(p);
        } catch (Exception e) {
            logger.info((e.getMessage()));
            return null;
        }
    }

    public Appointment getAppointmentById(long id){
        try {
            Optional<Appointment> app = repo.findById(id);
            if(app.isEmpty()){
                return null;
            }
            else{
                return app.get();
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return null;
    }

    public Appointment createAppointment(Appointment app){
        try {
            repo.save(app);
            logger.info("Saved Successfully : ");
            return app;
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return null;
    }

    public Appointment deleteAppointment(Long id){
        try {
            Optional<Appointment> app = repo.findById(id);
            if(app.isEmpty()){
                return null;
            }else{
                return app.get();
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return null;
    }

    public Appointment updateAppointment(Appointment app){
        try {
            Optional<Appointment> existingApp = repo.findById(app.getId());
            if(existingApp.isEmpty())
            {
                return null;
            }
            else{
                existingApp.get().setDoctorId(app.getDoctorId());
                existingApp.get().setPatientId(app.getPatientId());
                existingApp.get().setDate(app.getDate());
                repo.save(existingApp.get());
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return null;
    }
}
