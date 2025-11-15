package com.example.HMS.controllers;

import com.example.HMS.Entities.Bill;
import com.example.HMS.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    @Autowired
    private BillService service;
    @GetMapping()
    public Page<Bill> getAllBills(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
    ){
        return service.getAllBills(page,size);
    }

    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable long id){
        return service.getBillById(id);
    }

    @PostMapping
    public Bill createBill(@RequestBody Bill b){
        return service.createBill(b);
    }
    @PutMapping()
    public Bill updateBill(@RequestBody Bill b){
        return service.updateBill(b);
    }


    @DeleteMapping("/{id}")
    public Bill deleteBill(@PathVariable Long id){
        return service.deleteBills(id);
    }

}
