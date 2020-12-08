package com.ashokit.ies.dc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashokit.ies.dc.domain.SNAPPlan;

import com.ashokit.ies.dc.service.CaseServiceImpl;

@Controller
@RequestMapping("dc")
public class SNAPController {
	@Autowired
	CaseServiceImpl caseService;
	@PostMapping("/snap")
    public String handleNextButton(@ModelAttribute SNAPPlan plan,Model model) {
		
		Integer caseId=caseService.saveSNAPPlan(plan);
		model.addAttribute("caseId", caseId);
		
		return "ed";
	}
}
