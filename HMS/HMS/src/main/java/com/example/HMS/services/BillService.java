package com.example.HMS.services;

import com.example.HMS.Entities.Bill;
import com.example.HMS.Entities.Doctor;
import com.example.HMS.repositories.BillRepo;
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
public class BillService {

    private Logger logger = LoggerFactory.getLogger(BillService.class);

    @Autowired
    private BillRepo repo;

    //Done
    public Page<Bill> getAllBills(int page, int size){
        try {
            Pageable p = PageRequest.of(page, size);
            return repo.findAll(p);
        } catch (Exception e) {
            logger.info((e.getMessage()));
            return null;
        }
    }

    //Done
    public Bill getBillById(long Id){
        try {
            Optional<Bill> bill = repo.findById(Id);
            if(bill.isEmpty())
                return null;
            else
                return bill.get();
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    //Done
    public Bill createBill(Bill b){
        try {
            repo.save(b);
            return b;
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return null;
    }

    //Done
    public Bill deleteBills(Long id){
        try {
            Optional<Bill> bill = repo.findById(id);
            if(bill.isEmpty())
                return null;
            else
            repo.deleteById(id);
            return bill.get();

        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return null;
    }


    //Done
    public Bill updateBill(Bill b){
        try {
            Optional<Bill> bill = repo.findById(b.getId());
            if(bill.isEmpty())
            {
                return null;
            }else{
                bill.get().setAmount(b.getAmount());
                bill.get().setStatus(b.getStatus());
                bill.get().setPatientId(b.getPatientId());
                return bill.get();
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }

        return null;
    }
}
