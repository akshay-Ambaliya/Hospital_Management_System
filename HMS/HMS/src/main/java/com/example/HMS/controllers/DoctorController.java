package com.example.HMS.controllers;

import com.example.HMS.Entities.Doctor;
import com.example.HMS.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    public Page<Doctor> getAllDoctors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
    ){

        return service.getAllDoctors(page,size);
    }


    @GetMapping("/{id}")
    public Doctor getDoctorsById(@PathVariable long id){
        return service.getDoctorById(id);
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor d){
        return  service.createDoctor(d);
    }


    @DeleteMapping("/{id}")
    public Doctor deleteDoctor(@PathVariable long id){
        return service.deleteDoctor(id);
    }


    @PutMapping()
    public Doctor updateDoctor(@RequestBody Doctor d){
        return service.updateDoctor(d);
    }
}
