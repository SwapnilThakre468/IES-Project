package com.ashokit.ies.dc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashokit.ies.dc.domain.CaseDetails;
import com.ashokit.ies.dc.service.CaseServiceImpl;
@Controller
@RequestMapping("dc")
public class IESDCController {
	@Autowired
	CaseServiceImpl caseService;
	@GetMapping("/")
	public String loadIESForm(Model model) {
		model.addAttribute("msg", "Welcome To IES Data Collection.");
		return "iesdc";
	}
	
	@GetMapping("/createCase")
	public String handleCreateCaseHyperlink(Model model) {
		
	model.addAttribute("msg", "Search Application Details.");
	return "createcase";
	}
	
	@GetMapping("/viewCase")
	public  String handleViewCaseHyperlink(Model model) {
		List<CaseDetails> caseList=caseService.getAllCase();	
		model.addAttribute("caseList", caseList);
		return"viewcase";
	}

}
