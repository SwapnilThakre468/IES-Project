package com.ashokit.ies.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashokit.ies.ar.domain.ApplicationRegistration;

import com.ashokit.ies.ar.service.ARServiceImpl;

;

@Controller
@RequestMapping("ar")
public class CreateARController {
    @Autowired
	ARServiceImpl appService;
	@PostMapping("/saveApplication")
	public String handleSubmitButton(@ModelAttribute("application") ApplicationRegistration application,Model model) {
		
		if(application.getAppId()==null) {
			String  isSaved=appService.saveApplication(application);
		if(isSaved.equals("fail")) {
			model.addAttribute("failMsg", "Fail to Save Application");
		}else {
			model.addAttribute("succMsg", isSaved);	
		}
		}else {
			boolean  isUpdate=appService.updateApplication(application);
			if(isUpdate) {
			model.addAttribute("succMsg", "Application Updated Successfully");	
			}else {
				model.addAttribute("failMsg", "Fail to Update Application");
			}
		}
		
			
		
		
			
			
	
		
		
	
		return"createapplication";
	}
}
