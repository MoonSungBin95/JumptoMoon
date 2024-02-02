package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.SD_CommissionRate;
import com.example.demo.Entity.SD_Sales;
import com.example.demo.Entity.SD_Seller;
import com.example.demo.Entity.SD_SellerCommission;
import com.example.demo.Service.SD_SellerService;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/seller")
@Controller
public class SD_SellerController {
	
	@Autowired
	private SD_SellerService sellerService;
	
	@GetMapping("/list")
	public String search(Model model, @RequestParam(value="page",defaultValue ="0") int page,HttpServletRequest request) {
		String currentUrl = request.getRequestURI();
		model.addAttribute("currentUrl", currentUrl);
		
		Page<SD_Seller> paging = sellerService.searchAll(page);
		model.addAttribute("paging", paging);
		return "Seller_list";
	}
	
	@GetMapping("/sellercommission")
	public String searchCommission(Model model, @RequestParam(value="page",defaultValue ="0") int page,HttpServletRequest request) {
		String currentUrl = request.getRequestURI();
		model.addAttribute("currentUrl", currentUrl);
		
		Page<SD_SellerCommission> paging = sellerService.searchCommssion(page);
		model.addAttribute("paging", paging);
		return "Commission_list";
	}
	
	@GetMapping("/commissionrate")
	public String searchCommssionRate(Model model, @RequestParam(value="page",defaultValue ="0") int page,HttpServletRequest request) {
		String currentUrl = request.getRequestURI();
		model.addAttribute("currentUrl", currentUrl);
		
		Page<SD_CommissionRate> paging = sellerService.searchCommssionRate(page);
		model.addAttribute("paging", paging);
		return "CommissionRate_list";
	}
	
	@GetMapping("/sales")
	public String searcha(Model model, @RequestParam(value="page",defaultValue ="0") int page,HttpServletRequest request) {
		String currentUrl = request.getRequestURI();
		model.addAttribute("currentUrl", currentUrl);
		
		Page<SD_Sales> paging = sellerService.searchSales(page);
		model.addAttribute("paging", paging);
		return "Sales_list";
	}
	
	
	
	
	
	
	@GetMapping("/Register")
	public String Reg() {
		return "RegSeller_form";
	}
	
	@PostMapping("/Register")
	public String RegSeller(@RequestParam("sellerId") String sellerId,
	                         @RequestParam("businessNumber") String businessNumber,
	                         @RequestParam("contactInfo") String contactInfo,
	                         @RequestParam("email") String email,
	                         @RequestParam("ceoName") String ceoName,
	                         @RequestParam("address") String address,
	                         @RequestParam("contract") boolean contract) {
	    
	    sellerService.RegSeller(sellerId, businessNumber, contactInfo, email, ceoName, address, contract);
	    
	    return "Complete_RegSeller";
	}

}