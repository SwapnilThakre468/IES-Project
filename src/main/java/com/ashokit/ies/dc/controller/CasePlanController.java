package com.ashokit.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashokit.ies.dc.domain.Plan;
import com.ashokit.ies.dc.service.CaseServiceImpl;

@Controller
@RequestMapping("dc")
public class CasePlanController {
	@Autowired
   CaseServiceImpl caseService;
	@PostMapping("/plan")
	public String handleNextButton(@ModelAttribute Plan plan ,Model model) {
		
		model.addAttribute("caseID", plan.getCaseId());
		model.addAttribute("planName", plan.getPlanName());
		String planName=caseService.saveCasePlan(plan);
	    return  planName.toLowerCase()+"plan";	
	}
}
