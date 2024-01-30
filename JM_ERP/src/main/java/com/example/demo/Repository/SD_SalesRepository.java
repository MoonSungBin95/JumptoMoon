package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.SD_Sales;

public interface SD_SalesRepository extends JpaRepository<SD_Sales, Long> {
    Page<SD_Sales> findAll(Pageable pageable);
}

