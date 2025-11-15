package com.example.HMS.services;


import com.example.HMS.Entities.Doctor;
import com.example.HMS.Entities.Patient;
import com.example.HMS.repositories.DoctorRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo repo;

    private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

    //Done
    public Page<Doctor> getAllDoctors(int page, int size){
        try {
            return repo.findAll(PageRequest.of(page,size));
        } catch (Exception e) {
            logger.info((e.getMessage()));
            return null;
        }
    }

    //Done

    public Doctor getDoctorById(long id){
        try {
            Optional<Doctor> d = repo.findById(id);
            if(d.isEmpty())
                return null;
            else {
                return d.get();
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return null;
    }

    //Done
    public Doctor createDoctor(Doctor d){
        try {
            repo.save(d);
            return d;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }

//        return null;
    }

    //Done
    public Doctor deleteDoctor(long id){
        try {
            logger.info("Deleted Successfully : ");
            Optional<Doctor> p = repo.findById(id);
            if(!p.isEmpty()){
                repo.deleteById(id);
                return p.get();
            }
            else
                return null;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    //Done
    public Doctor updateDoctor(Doctor d){
        try {
            Optional<Doctor> doc = repo.findById(d.getId());
            if(doc.isEmpty()){
                logger.info("User not found");
                return null;
            }else{
                doc.get().setName(d.getName());
                doc.get().setAge(d.getAge());
                doc.get().setSpeciality(d.getSpeciality());
                repo.save(doc.get());

                return doc.get();
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return null;
    }
}
