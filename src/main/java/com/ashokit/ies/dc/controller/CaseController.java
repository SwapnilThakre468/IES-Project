package com.ashokit.ies.dc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashokit.ies.dc.domain.CaseDetails;
import com.ashokit.ies.dc.domain.Plan;
import com.ashokit.ies.dc.service.CaseServiceImpl;

@Controller
@RequestMapping("dc")
public class CaseController {
	@Autowired
	CaseServiceImpl caseService;
    @GetMapping("/search") 
	public  String handleSearchBox(@RequestParam("appId")String appId,Model model) {
		CaseDetails caseDetails=caseService.bringARDetails(appId);
		if(caseDetails==null) {
			model.addAttribute("failmsg", "Wrong Applicaion ID.");
		}else {
			model.addAttribute("caseDetail", caseDetails);
		}
		return "createcase";
	}
    @PostMapping("/selectplan")
    public String handleCreateButton(@ModelAttribute("caseDetail") CaseDetails caseDetail,Model model) {
    	Integer caseId=caseService.saveCaseDetails(caseDetail);
    	List<String> planList=caseService.getPlanList();
    	Plan plan=new Plan();
    	model.addAttribute("plan", plan);
    	model.addAttribute("msg", "Choose Plan");
    	model.addAttribute("caseId", caseId);
    	model.addAttribute("planList", planList);
    	return "plan";
    }
}
