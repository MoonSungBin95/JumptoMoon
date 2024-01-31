package com.example.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.AC_PurchaseSlip;

@Repository
public interface AC_PurchaseSlipRepository extends JpaRepository<AC_PurchaseSlip, String> {
	
    Page<AC_PurchaseSlip> findAll(Pageable pageable);
}
