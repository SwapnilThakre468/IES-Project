package com.ashokit.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashokit.ies.admin.domain.DHSPlan;
import com.ashokit.ies.admin.service.DHSEmployeeServiceImpl;
@Controller
@RequestMapping("/admin")
public class CreatePlanController {
	@Autowired
	DHSEmployeeServiceImpl dhsAccountService;
	
	
	
	
	@PostMapping("/savePlan")
	public String handleSubmitButton(@ModelAttribute("plan") DHSPlan plan,Model model) {
		
		boolean isSaved=dhsAccountService.savePlan(plan);
		
		
		if(isSaved) {
			
			if(plan.getPlanId() !=null) {
				
			model.addAttribute("succMsg", "Plan Updated Successfully");
		}else
		{
			model.addAttribute("succMsg", "Plan Saved Successfully");
			
		}
	}else {
		
		model.addAttribute("failMsg", "Fail to Save Plan");
	}
		return"createplan";
	}

}
