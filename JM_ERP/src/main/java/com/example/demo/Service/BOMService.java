package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.BOM;
import com.example.demo.Repository.BOMRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BOMService {
	
	private final BOMRepository bomrepository;

    public List<BOM> getList() {
        return bomrepository.findAll();
    }
}