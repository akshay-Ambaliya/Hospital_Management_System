package com.example.HMS.controllers;


import com.example.HMS.Entities.Appointment;
import com.example.HMS.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.management.DescriptorKey;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping()
    public Page<Appointment> getAllAppointments(@RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "2") int size){
        return service.getAllAppointment(page,size);
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable long id){

        return service.getAppointmentById(id);

    }

    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment app){

        return service.createAppointment(app);
    }

    @PutMapping
    public Appointment updateAppointment(@RequestBody Appointment app){
        return service.updateAppointment(app);
    }

    @DeleteMapping("/{id}")
    public Appointment deleteAppointment(@PathVariable long id){

        return service.deleteAppointment(id);
    }
}
