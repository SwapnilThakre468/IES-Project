package com.ashokit.ies.admin.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashokit.ies.admin.domain.DHSEmployeeAccount;
import com.ashokit.ies.admin.domain.DHSPlan;
import com.ashokit.ies.admin.service.DHSEmployeeServiceImpl;




@Controller
@RequestMapping("/admin")
public class IESAdminController {
	
	@Autowired
	private DHSEmployeeServiceImpl dhsAccountService;

	@GetMapping("/")
	public String loadIESForm(Model model) {
		model.addAttribute("msg", "Welcome To IES");
		return "iesadmin";
	}
	
	@GetMapping("/createAccount")
	public String handleCreateAccountHyperlink(Model model) {
		DHSEmployeeAccount  account=new DHSEmployeeAccount();
		model.addAttribute("account", account);
		List<String> roleList=new ArrayList<String>();
		roleList.add("Admin");
		roleList.add("CaseWorker");
		model.addAttribute("roleList", roleList);
		return"createaccount";
		
	}@GetMapping("/createPlan")
	public String handleCreatePlanHyperlink(Model model) {
		DHSPlan plan=new DHSPlan();
		model.addAttribute("plan", plan);
		return"createplan";
		
	}
	@GetMapping("/viewPlan")
	public String handleViewPlanHyperlink(Model model) {
		
		List<DHSPlan> planList =dhsAccountService.getAllPlanDetails();
		
		
		model.addAttribute("planList", planList);
		
		
		return"planview";
		
	}
	
	
	
	@GetMapping("/accountView")
	public String handleViewAccountHyperlink(Model model) {
		
		List<DHSEmployeeAccount> accountList =dhsAccountService.getAccountByRole("Admin");
		
		
		model.addAttribute("accountList", accountList);
		List<String> roleList=new ArrayList<String>();
		roleList.add("Admin");
		roleList.add("CaseWorker");
		model.addAttribute("roleList", roleList);
		
		return"accountview";
		
	}
	

}
