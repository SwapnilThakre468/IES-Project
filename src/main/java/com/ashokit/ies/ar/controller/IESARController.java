package com.ashokit.ies.ar.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashokit.ies.ar.domain.ApplicationRegistration;


import com.ashokit.ies.ar.service.ARServiceImpl;

@Controller
@RequestMapping("ar")
public class IESARController {

	@Autowired
	ARServiceImpl appService;
	@GetMapping("/")
	public String loadIESForm(Model model) {
		model.addAttribute("msg", "Welcome To IES Application Registration.");
		return "iesappreg";
	}
	
	@GetMapping("/createApplication")
	public String handleCreateApplicationHyperlink(Model model) {
		ApplicationRegistration application=new ApplicationRegistration();
		model.addAttribute("application", application);
		
		return"createapplication";
		
	}
	
	@GetMapping("/applicationView")
	public String handleViewApplicationHyperlink(Model model) {
		
		List<ApplicationRegistration> applicationList =appService.getAllApplication();
		
		model.addAttribute("applicationList", applicationList);
				
		return"applicationview";
		
	}
}