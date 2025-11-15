package com.example.HMS.repositories;

import com.example.HMS.Entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill,Long> {
}
