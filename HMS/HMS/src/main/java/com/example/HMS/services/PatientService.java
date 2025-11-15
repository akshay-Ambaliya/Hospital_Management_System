package com.example.HMS.services;

import com.example.HMS.Entities.Patient;
import com.example.HMS.repositories.PatientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepo repo;
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    //done
    public Page<Patient> getAllPatient(int page,int size){
        try{
            return repo.findAll(PageRequest.of(page,size));
        }catch(Exception e){
            logger.error("Something Went Wrong : {}",e.getMessage());
            return null;
        }
    }


    //Done
    public Patient getPatientById(long id){
        try{
            Optional<Patient> p = repo.findById(id);
            if(p.isEmpty()){
                logger.info("Sorry data Not found ");
                return null;
            }
            return p.get();
        }catch(Exception e){
            logger.error( e.getMessage());
            return null;
        }
    }

    //Done
    public Patient createPatient(Patient p){
        try {
            repo.save(p);
            logger.info("Saved Successfully : ");
            return p;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }


    //Done
    public Patient deletePatient(long id){
        try {
            logger.info("Deleted Successfully : ");
            Optional<Patient> p = repo.findById(id);
            if(!p.isEmpty()){
                repo.deleteById(id);
                return p.get();
            }
            else
                return null;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    //Done
    public Patient updatePatient(Patient p){
        try{
            repo.save(p);
            logger.info("Updated Successfully : ");
            return p;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
