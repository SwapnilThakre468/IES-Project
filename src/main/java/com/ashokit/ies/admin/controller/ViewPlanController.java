package com.ashokit.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.ashokit.ies.admin.domain.DHSPlan;
import com.ashokit.ies.admin.service.DHSEmployeeServiceImpl;
@Controller
@RequestMapping("/admin")
public class ViewPlanController {
	@Autowired
	DHSEmployeeServiceImpl dhsAccountService;
	
	
	@GetMapping("/editPlan")
	 public String handleEditPlanHyperlink(@RequestParam("planId")Integer  planId,Model model) {
		
		DHSPlan plan= dhsAccountService.getPlanById(planId);
		 model.addAttribute("plan", plan);
		 
		 return "createplan";
	 }
	 @GetMapping("/deletePlan")
	 public String handleDeletePlanHyperlink(@RequestParam("planId")Integer   planId, RedirectAttributes rAtrribute) {
		 
		  dhsAccountService.deletePlan(planId);
		 rAtrribute.addFlashAttribute("delsucc","Plan Deleted Successfully");
		 
		 return "redirect:viewPlan";
	 }
}
