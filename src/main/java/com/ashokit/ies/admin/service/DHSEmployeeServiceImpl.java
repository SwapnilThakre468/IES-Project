package com.ashokit.ies.admin.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ashokit.ies.admin.domain.DHSEmployeeAccount;
import com.ashokit.ies.admin.domain.DHSPlan;
import com.ashokit.ies.admin.entity.DHSEmployeeAccountEntity;
import com.ashokit.ies.admin.entity.DHSPlanEntity;
import com.ashokit.ies.admin.repository.DHSEmployeeRepository;
import com.ashokit.ies.admin.repository.DHSPlanRepository;
import com.ashokit.ies.util.EmailUtils;

@Service
public class DHSEmployeeServiceImpl implements DHSEmployeeService {
    @Autowired
	DHSEmployeeRepository employeeRepo;
    @Autowired
    EmailUtils emailUtils;
    @Autowired
    DHSPlanRepository planRepo;
	@Override
	public  boolean saveAccount(DHSEmployeeAccount account) {
		
		DHSEmployeeAccountEntity accountEntity=new  DHSEmployeeAccountEntity();
		
		accountEntity.setFirstName(account.getFirstName());
		accountEntity.setLastName(account.getLastName());
		accountEntity.setEmail(account.getEmail());
		accountEntity.setPhoneNo(account.getPhoneNo());
		accountEntity.setEmployeeId(account.getEmployeeId());
		accountEntity.setGender(account.getGender());
		accountEntity.setRole(account.getRole());
		accountEntity.setPassword(account.getPassword());
		accountEntity.setSsn(account.getSsn());
		accountEntity.setDob(formatDate(account.getDob()));
		if(account.getEmployeeId()==null) {
		accountEntity.setStatus("Active");
		DHSEmployeeAccountEntity savedEntity=employeeRepo.save(accountEntity);
		sendEmail(account.getEmail()," Call Letter|IES", getEmailBody(account));
		return savedEntity.getEmployeeId()!=null;
		}else {
			accountEntity.setStatus(account.getStatus());
			DHSEmployeeAccountEntity savedEntity=employeeRepo.save(accountEntity);
			return savedEntity.getEmployeeId()!=null;
		}
		
	}
	
	/*@Override
	public boolean updateAccount(DHSEmployeeAccount account) {
		DHSEmployeeAccountEntity accountEntity=new  DHSEmployeeAccountEntity();
		BeanUtils.copyProperties(account, accountEntity);
		DHSEmployeeAccountEntity updateEntity=employeeRepo.save(accountEntity);
		
		return updateEntity.equals(accountEntity);
	}*/
	
	@Override
	public String getEmailBody(DHSEmployeeAccount account) {
		String filename="DHS_EMPLOYEE_EMAIL_BODY_TEMPLATE.txt";
		List<String> replaceLines=null;
		String mailBody=null;
		try {
			Path path=Paths.get(filename, "");
			@SuppressWarnings("resource")
			Stream<String> pipes=Files.lines(path);
			replaceLines=pipes.map(line->line.replace("{FNAME}", account.getFirstName())
					                          .replace("{LNAME}", account.getLastName())
					                          .replace("{ROLE}", account.getRole())
					                          .replace("{EMAIL}", account.getEmail())
											  .replace("{PWD}", account.getPassword()))
											  .collect(Collectors.toList());
			mailBody=String.join("",replaceLines);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mailBody;
	}

	@Override
	public boolean sendEmail(String to, String subject, String body) {
		
		return emailUtils.sendEmail(to, subject, body);
	}


	@Override
	public List<DHSEmployeeAccount> getAccountByRole(String role) {
		/*List<DHSEmployeeAccountEntity> accountEntityList=employeeRepo.findAll();*/
		List<DHSEmployeeAccountEntity> accountEntityList=employeeRepo.findByRole(role);
		List<DHSEmployeeAccount> accountList=new ArrayList<DHSEmployeeAccount>();
		for(DHSEmployeeAccountEntity accountEntity: accountEntityList) {
			DHSEmployeeAccount account=new DHSEmployeeAccount();
			account.setFirstName(accountEntity.getFirstName());
			account.setLastName(accountEntity.getLastName());
			account.setEmail(accountEntity.getEmail());
			account.setPhoneNo(accountEntity.getPhoneNo());
			account.setEmployeeId(accountEntity.getEmployeeId());
			account.setGender(accountEntity.getGender());
			account.setRole(accountEntity.getRole());
			account.setPassword(accountEntity.getPassword());
			account.setSsn(accountEntity.getSsn());
			account.setDob(formatString(accountEntity.getDob()));
			account.setStatus(accountEntity.getStatus());
			
			accountList.add(account);
		}
		return accountList;
	}

	@Override
	public DHSEmployeeAccount getAccountById(Integer employeeId) {
		
		Optional<DHSEmployeeAccountEntity> optional= employeeRepo.findById(employeeId);
		if(optional.isPresent()) {
			DHSEmployeeAccount account=new DHSEmployeeAccount();
			DHSEmployeeAccountEntity accountEntity=optional.get();
			account.setFirstName(accountEntity.getFirstName());
			account.setLastName(accountEntity.getLastName());
			account.setEmail(accountEntity.getEmail());
			account.setPhoneNo(accountEntity.getPhoneNo());
			account.setEmployeeId(accountEntity.getEmployeeId());
			account.setGender(accountEntity.getGender());
			account.setRole(accountEntity.getRole());
			account.setPassword(accountEntity.getPassword());
			account.setSsn(accountEntity.getSsn());
			account.setDob(formatString(accountEntity.getDob()));
			account.setStatus(accountEntity.getStatus());
			return account;
		}
			
		return null;
		
		
	}

	

	@Override
	public boolean deleteAccount(Integer employeeId) {
		DHSEmployeeAccountEntity accountEntity = null ;
		Optional<DHSEmployeeAccountEntity> optional=employeeRepo.findById(employeeId);
		if(optional.isPresent()) {
			accountEntity=optional.get();
	    if(accountEntity.getStatus().equals("Active")){
	    	accountEntity.setStatus("Inactive");
	    	
	    }else {
	    	accountEntity.setStatus("Active");
	    }
		}
		DHSEmployeeAccountEntity deactiveEntity=employeeRepo.save(accountEntity);
		return deactiveEntity!=null;
	}
	public String isUniqueEmail(String email) {
		DHSEmployeeAccountEntity accountEntity=employeeRepo.findByEmail(email);
		if( accountEntity==null) {
			return "unique";
		}else {
			return "duplicate";
		}
	}
	@Override
	public boolean savePlan(DHSPlan plan) {
		
		DHSPlanEntity planEntity=new DHSPlanEntity();

        planEntity.setPlanName(plan.getPlanName());
        planEntity.setPlanDescrp(plan.getPlanDescrp());
        planEntity.setPlanId(plan.getPlanId());
        planEntity.setStartDate(formatDate(plan.getStartDate()));
        planEntity.setEndDate(formatDate(plan.getEndDate()));
        if(plan.getPlanId()==null) {
		planEntity.setStatus("Active");
        }else {
        	planEntity.setStatus(plan.getStatus());
        }
		DHSPlanEntity savedEntity=planRepo.save(planEntity);
		return savedEntity.getPlanId()!=null;
		
	}
	/*@Override
	public boolean updatePlan(DHSPlan plan) {
		
		DHSPlanEntity planEntity=new DHSPlanEntity();
		BeanUtils.copyProperties(plan, planEntity);
		DHSPlanEntity updateEntity=planRepo.save(planEntity);
		return updateEntity.getPlanId()!=null;
	}*/
	@Override
	public boolean deletePlan(Integer planId) {
		DHSPlanEntity planEntity=null;
		Optional<DHSPlanEntity> optional=planRepo.findById(planId);
		if(optional.isPresent()) {
			 planEntity=optional.get();
			if(planEntity.getStatus().equals("Active")) {
				planEntity.setStatus("Inactive");
			}else {
				planEntity.setStatus("Active");
			}
		}       
		DHSPlanEntity deactiveEntity=planRepo.save(planEntity);
		return deactiveEntity!=null;
	}
	@Override
	public List<DHSPlan> getAllPlanDetails() {
		
		List<DHSPlan> plans=new ArrayList<>();
		List<DHSPlanEntity>entitys=  planRepo.findAll();
		for(DHSPlanEntity planEntity: entitys) {
			DHSPlan plan=new DHSPlan();
			  plan.setPlanName(planEntity.getPlanName());
		        plan.setPlanDescrp(planEntity.getPlanDescrp());
		        plan.setPlanId(planEntity.getPlanId());
		        plan.setStartDate(formatString(planEntity.getStartDate()));
		        plan.setEndDate(formatString(planEntity.getEndDate()));
		        plan.setStatus(planEntity.getStatus());
			plans.add(plan);
			
		}
		return plans;
	}
	@Override
	public DHSPlan getPlanById(Integer planId) {
		
	DHSPlan plan=new DHSPlan();
		Optional<DHSPlanEntity> optional= planRepo.findById(planId);
		if(optional.isPresent()) {
			DHSPlanEntity planEntity=optional.get();
			 plan.setPlanName(planEntity.getPlanName());
		        plan.setPlanDescrp(planEntity.getPlanDescrp());
		        plan.setPlanId(planEntity.getPlanId());
		        plan.setStartDate(formatString(planEntity.getStartDate()));
		        plan.setEndDate(formatString(planEntity.getEndDate()));
		        plan.setStatus(planEntity.getStatus());
			return plan;
		}
			return null;
	}
	@Override
	public String formatString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		return strDate;
	}

	@Override
	public Date formatDate(String date) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("dd/MM/yyyy").parse(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date1;
	}
}
