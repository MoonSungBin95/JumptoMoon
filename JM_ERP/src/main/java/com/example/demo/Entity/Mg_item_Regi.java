package com.example.demo.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Mg_item_Regi {

	@Column
	private String Itemname;
	//물품이름
	@Id
	private String itemCode;
	//물품코드
	@Column
	private int itemCost;
//	물품원가
	@Column
	private String itemType;
	//물품 종류
	@Column
	private LocalDate itemReciving;
	//물품 등록 날짜
	
	@OneToMany(mappedBy = "itemCode",cascade = CascadeType.ALL)
	private List<Mg_WMS> wms = new ArrayList<>();

	@OneToMany(mappedBy = "itemCode",cascade = CascadeType.ALL)
	private List<Mg_Sn> sn = new ArrayList<>();
	
	
	
	public String toString() {
	    return this.itemCode;
	}
	
	
}



										//																																							