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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.dc.domain.CCAPPlan;

import com.ashokit.ies.dc.service.CaseServiceImpl;

@Controller
@RequestMapping("dc")
public class CCAPController {
	@Autowired
	CaseServiceImpl caseService;

	@PostMapping("/addChildRecord")
	public String handleAddButton(@ModelAttribute("plan") CCAPPlan plan, Model model) {

		caseService.saveCCAPPlan(plan);
		List<CCAPPlan> planList = caseService.getCCAPAllCase();
		model.addAttribute("planList", planList);
		return "ccapplan";
	}

	@GetMapping("/editChildRecord")
	public String handleEditPlanHyperlink(@RequestParam("caseId") Integer caseId, Model model) {

		CCAPPlan plan = caseService.getCCAPCaseById(caseId);
		model.addAttribute("plan", plan);

		return "ccapplan";
	}

	@GetMapping("/deleteChildRecord")
	public String handleDeletePlanHyperlink(@RequestParam("caseId") Integer caseId, RedirectAttributes rAtrribute) {

		caseService.deleteCCAPPlan(caseId);
		rAtrribute.addFlashAttribute("delsucc", "Child record Deleted Successfully");

		return "redirect:ccapplan";
	}

	@PostMapping("/ccap")
	public String handleNextButton(@ModelAttribute CCAPPlan plan, Model model) {

		Integer caseId = caseService.saveCCAPPlan(plan);
		model.addAttribute("caseId", caseId);

		return "ed";
	}
}
