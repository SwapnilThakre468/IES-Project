package com.ashokit.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ashokit.ies.admin.domain.DHSEmployeeAccount;

import com.ashokit.ies.admin.service.DHSEmployeeServiceImpl;

@Controller
@RequestMapping("/admin")
public class CreateAccountController {
	@Autowired
	DHSEmployeeServiceImpl dhsAccountService;
	
	
	
	@GetMapping("/uniqueMailCheck")
	public @ResponseBody String uniqueMailCheckEvent(@RequestParam("email") String email) {

	String isUnique= dhsAccountService.isUniqueEmail(email);
	
		return isUnique;

}
	@PostMapping("/saveAccount")
	public String handleSubmitButton(@ModelAttribute("account") DHSEmployeeAccount account,Model model) {
		boolean  isSaved=dhsAccountService.saveAccount(account);
		if(isSaved) {
			
			if(account.getEmployeeId()!=null) {
				
			model.addAttribute("succMsg", "Account Updated Successfully");
		}else
		{
			model.addAttribute("succMsg", "Account Saved Successfully");
			
		}
	}else {
		
		model.addAttribute("failMsg", "Fail to Save Account");
	}
		return"createaccount";
	}

}
