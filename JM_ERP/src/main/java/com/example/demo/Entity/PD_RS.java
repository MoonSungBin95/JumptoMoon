package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.Getter;

@Entity
public class PD_RS {
	@Id
	private String RelNum;
	
	private String StoNum;
	
	private String rFrom;
	
	private String sTO;
	
	private String ProdName;
	
	private Integer Num;
	
	private Integer ProdCost;
	
	private Integer OutSrcCost;
	
	private Integer OutSrcTot;	
	
}