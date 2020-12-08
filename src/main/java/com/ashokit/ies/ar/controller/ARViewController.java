package com.ashokit.ies.ar.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.ar.domain.ApplicationRegistration;
import com.ashokit.ies.ar.service.ARServiceImpl;

@Controller
@RequestMapping("ar")
public class ARViewController {
	
	@Autowired
	ARServiceImpl appService;
	@GetMapping("/editApplication")
	 public String handleEditApplicationHyperlink(@RequestParam("appId")String appId,Model model) {
		
		ApplicationRegistration application=appService.getApplicationById(appId);
		model.addAttribute("application", application);
		return "createapplication";
	 }
	 @GetMapping("/deleteApplication")
	 public String handleDeleteApplicationHyperlink(@RequestParam("appId")String   appId, RedirectAttributes rAtrribute) {
		 
		 String msg= appService.deleteApplication(appId);
		 if(msg.equals("Active")) {
			 rAtrribute.addFlashAttribute("delsucc","Application Activated Successfully");
		 }else {
			 rAtrribute.addFlashAttribute("delsucc","Application Deleted Successfully");
		 }
		
		 
		 return "redirect:applicationView";
	 }
}
