package com.example.demo.Controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.AC_DepositSlip;
import com.example.demo.Entity.AC_SaleSlip;
import com.example.demo.Entity.PD_BOM;
import com.example.demo.Entity.SD_Product;
import com.example.demo.Service.AC_DepositSlipService;
import com.example.demo.Service.AC_SaleSlipService;
import com.example.demo.Service.PD_BOMService;
import com.example.demo.Service.SD_productService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MainController {
	
	private final PD_BOMService bomservice;
	private final AC_SaleSlipService saleSlipService;
	private final AC_DepositSlipService depositSlipService;
	private final SD_productService productService;
	
	@GetMapping("/")
    public String index(Model model, @RequestParam(value="page", defaultValue="0") int page, HttpServletRequest request) {
    	String currentUrl = request.getRequestURI();
    	model.addAttribute("currentUrl", currentUrl);
    	
    	Page<PD_BOM> bomlist = bomservice.getList(page);
    	Page<AC_SaleSlip> sale = this.saleSlipService.getList(page);
    	Page<AC_DepositSlip> purchase = this.depositSlipService.getList(page);
    	Page<SD_Product> paging = productService.searchAllproduct(page);
    	
        model.addAttribute("bomlist", bomlist);
        model.addAttribute("saleSlipList", sale);
        model.addAttribute("purchaseSlipList", purchase);
        model.addAttribute("regshop",paging);
    	return "index"; // resources/templates/index.html을 가리킵니다.
    }
}
	