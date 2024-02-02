package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.PC_OrderSheet;
import com.example.demo.Entity.PC_PurchaseInquiry;
import com.example.demo.Service.SD_PurchaseService;

import jakarta.servlet.http.HttpServletRequest;
@RequestMapping("/purchase")
@Controller
public class SD_Purchasecontroller {
	
	
	@Autowired
	private SD_PurchaseService purchaseservice; 
	
	

    
	@GetMapping("/ordersheet")
	public String search(Model model, @RequestParam(value="page",defaultValue ="0") int page,HttpServletRequest request) {
		String currentUrl = request.getRequestURI();
		model.addAttribute("currentUrl", currentUrl);
		
		Page<PC_OrderSheet> paging = purchaseservice.searchOrderSheet(page);
		model.addAttribute("paging", paging);
		return "OrderSheet_list";
	}
	
	@GetMapping("/purchaseinquiry")
	public String searchPurchaseInquiry(Model model, @RequestParam(value="page",defaultValue ="0") int page,HttpServletRequest request) {
		String currentUrl = request.getRequestURI();
		model.addAttribute("currentUrl", currentUrl);
		
		Page<PC_PurchaseInquiry> paging = purchaseservice.searchPurchaseInquiry(page);
		model.addAttribute("paging", paging);
		return "PurchaseInquiry_list";
	}
	
	
	
}