package com.example.HMS.controllers;


import com.example.HMS.Entities.Patient;
import com.example.HMS.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping()
    public Page<Patient> getAllPatients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
    ){
        return service.getAllPatient(page,size);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient p){
        System.out.println("Creating Patient");
        service.createPatient(p);
        return p;
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return service.getPatientById(id);
    }

    @DeleteMapping("/{id}")
    public Patient deletePatient(@PathVariable Long id){
        return service.deletePatient(id);
    }

    @PutMapping()
    public Patient updatePatient(@RequestBody Patient p){
        return service.updatePatient(p);
    }
}
