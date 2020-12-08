package com.ashokit.ies.admin.service;

import java.util.Date;
import java.util.List;


import com.ashokit.ies.admin.domain.DHSEmployeeAccount;
import com.ashokit.ies.admin.domain.DHSPlan;

public interface DHSEmployeeService {
	public boolean  saveAccount(DHSEmployeeAccount account);
	public DHSEmployeeAccount getAccountById(Integer employeeId);
	public boolean deleteAccount(Integer employeeId);
	/*public boolean updateAccount(DHSEmployeeAccount account);*/
	public List<DHSEmployeeAccount> getAccountByRole(String role);
	public String getEmailBody(DHSEmployeeAccount account);
	boolean sendEmail(String to, String subject, String body);
	public String isUniqueEmail(String email);
	public boolean savePlan(DHSPlan plan);
	/*public boolean updatePlan(DHSPlan plan);*/
	public boolean deletePlan(Integer planId);
	public List<DHSPlan> getAllPlanDetails();
	public DHSPlan getPlanById(Integer planId);
	public Date formatDate(String date);
	public String formatString(Date date);
	
	
}
