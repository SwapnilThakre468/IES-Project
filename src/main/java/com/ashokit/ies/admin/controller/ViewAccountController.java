package com.ashokit.ies.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ashokit.ies.admin.domain.DHSEmployeeAccount;
import com.ashokit.ies.admin.service.DHSEmployeeServiceImpl;



@Controller
@RequestMapping("/admin")
public class ViewAccountController {
	
	@Autowired
	DHSEmployeeServiceImpl dhsAccountService;
	
	
	@GetMapping("/editAccount")
	 public String handleEditAccountHyperlink(@RequestParam("employeeId")Integer  employeeId,Model model) {
		
		DHSEmployeeAccount account = dhsAccountService.getAccountById(employeeId);
		 model.addAttribute("account", account);
		 List<String> roleList=new ArrayList<String>();
			roleList.add("Admin");
			roleList.add("CaseWorker");
			model.addAttribute("roleList", roleList);
		 return "createaccount";
	 }
	 @GetMapping("/deleteAccount")
	 public String handleDeleteAccountHyperlink(@RequestParam("employeeId")Integer   employeeId, RedirectAttributes rAtrribute) {
		 
		  dhsAccountService.deleteAccount(employeeId);
		 rAtrribute.addFlashAttribute("delsucc","Account Deleted Successfully");
		 
		 return "redirect:accountView";
	 }
	 @GetMapping("/dropdownAccount")
	 public  String handleRoleDropdown(@RequestParam("role") String   role , RedirectAttributes rAtrribute) {
		 
		     List<DHSEmployeeAccount> accountList =dhsAccountService.getAccountByRole(role);
		     rAtrribute.addFlashAttribute("accountList",accountList);
		
			return "redirect:accountView";	
	 }
		
}
