package com.ashokit.ies.dc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ashokit.ies.admin.domain.DHSPlan;
import com.ashokit.ies.admin.service.DHSEmployeeServiceImpl;
import com.ashokit.ies.ar.domain.ApplicationRegistration;
import com.ashokit.ies.ar.service.ARServiceImpl;
import com.ashokit.ies.dc.domain.CCAPPlan;
import com.ashokit.ies.dc.domain.CaseDetails;
import com.ashokit.ies.dc.domain.KTWORKPlan;
import com.ashokit.ies.dc.domain.Plan;
import com.ashokit.ies.dc.domain.SNAPPlan;
import com.ashokit.ies.dc.entity.CCAPPlanEntity;
import com.ashokit.ies.dc.entity.CaseDetailsEntity;
import com.ashokit.ies.dc.entity.KTWORKPlanEntity;
import com.ashokit.ies.dc.entity.PlanEntity;
import com.ashokit.ies.dc.entity.SNAPPlanEntity;
import com.ashokit.ies.dc.repository.CCAPRepository;
import com.ashokit.ies.dc.repository.CasePlanRepository;
import com.ashokit.ies.dc.repository.CaseRepository;
import com.ashokit.ies.dc.repository.KTWORKRepository;
import com.ashokit.ies.dc.repository.SNAPRepository;
@Service
public class CaseServiceImpl implements CaseService {
	
	@Autowired
	DHSEmployeeServiceImpl adminService;
	@Autowired
	ARServiceImpl arService;
	@Autowired
	CaseRepository caseRepo;
	@Autowired
	CasePlanRepository planRepo;
	@Autowired
	CCAPRepository ccapRepo;
	@Autowired
	SNAPRepository snapRepo;
	@Autowired
	KTWORKRepository ktworkRepo;

	@Override
	public CaseDetails bringARDetails(String appId) {
		CaseDetails caseDetails = new CaseDetails();
		ApplicationRegistration ar = arService.getApplicationById(appId);
		if(ar!=null) {
			ar.setSsn(formatSSN(ar.getSsn()));
		BeanUtils.copyProperties(ar, caseDetails);
		return caseDetails;
		}else {
			return null;
		}
	}

	@Override
	public Integer saveCaseDetails(CaseDetails caseDetails) {
		CaseDetailsEntity caseEntity = new CaseDetailsEntity();
		caseEntity.setAppId(caseDetails.getAppId());
		caseEntity.setCaseId(caseDetails.getCaseId());
		caseEntity.setDob(formatDate(caseDetails.getDob()));
		caseEntity.setEmail(caseDetails.getEmail());
		caseEntity.setFirstName(caseDetails.getFirstName());
		caseEntity.setLastName(caseDetails.getLastName());
		caseEntity.setGender(caseDetails.getGender());
		caseEntity.setPhoneNo(caseDetails.getPhoneNo());
		caseEntity.setSsn(caseDetails.getSsn());
		if(caseDetails.getCaseId()==null) {
			caseEntity.setStatus("Active");
		}else {
			caseEntity.setStatus(caseDetails.getStatus());
		}
		
		CaseDetailsEntity saveCase = caseRepo.save(caseEntity);
		
		return saveCase.getCaseId() != null?saveCase.getCaseId():null;
	}

	@Override
	public boolean changeCaseStatus(Integer caseId) {
		Optional<CaseDetailsEntity> optionalEntity = caseRepo.findById(caseId);
		CaseDetailsEntity changeStatus = null;
		if (optionalEntity.isPresent()) {
			changeStatus = optionalEntity.get();
			if (changeStatus.getStatus().equals("Active")) {
				changeStatus.setStatus("Inactive");

			} else {
				changeStatus.setStatus("Active");
			}

		}
		return caseRepo.save(changeStatus) != null;
	}

	@Override
	public CaseDetails getCaseById(Integer caseId) {
		Optional<CaseDetailsEntity> optionalEntity = caseRepo.findById(caseId);
		CaseDetails caseDetails = new CaseDetails();
		if (optionalEntity.isPresent()) {
			CaseDetailsEntity caseEntity = optionalEntity.get();

			caseDetails.setAppId(caseEntity.getAppId());
			caseDetails.setCaseId(caseEntity.getCaseId());
			caseDetails.setDob(formatString(caseEntity.getDob()));
			caseDetails.setEmail(caseEntity.getEmail());
			caseDetails.setFirstName(caseEntity.getFirstName());
			caseDetails.setLastName(caseEntity.getLastName());
			caseDetails.setGender(caseEntity.getGender());
			caseDetails.setPhoneNo(caseEntity.getPhoneNo());
			caseDetails.setSsn(caseEntity.getSsn());
			caseDetails.setStatus(caseEntity.getStatus());
			return caseDetails;
		}
		return null;
	}

	@Override
	public List<CaseDetails> getAllCase() {
		List<CaseDetailsEntity> caseEntityList=caseRepo.findAll();
		List<CaseDetails> caseList=new ArrayList<CaseDetails>();
		caseEntityList.forEach(caseEntity->{
			CaseDetails caseDetails=new CaseDetails();
			caseDetails.setAppId(caseEntity.getAppId());
			caseDetails.setCaseId(caseEntity.getCaseId());
			caseDetails.setDob(formatString(caseEntity.getDob()));
			caseDetails.setEmail(caseEntity.getEmail());
			caseDetails.setFirstName(caseEntity.getFirstName());
			caseDetails.setLastName(caseEntity.getLastName());
			caseDetails.setGender(caseEntity.getGender());
			caseDetails.setPhoneNo(caseEntity.getPhoneNo());
			caseDetails.setSsn(caseEntity.getSsn());
			caseDetails.setStatus(caseEntity.getStatus());
			
			 caseList.add(caseDetails);
		});
		return caseList;
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
			
			e.printStackTrace();
		}
		return date1;
	}

	@Override
	public List<String> getPlanList() {
		List<DHSPlan> planDetailsList=adminService.getAllPlanDetails();
		List<String> planList=new ArrayList<>();
		planDetailsList.forEach(plan->{
			planList.add(plan.getPlanName());
		});
		return planList;
	}

	@Override
	public String saveCasePlan(Plan casePlan) {
		PlanEntity planEntity=new PlanEntity();
		BeanUtils.copyProperties(casePlan, planEntity);
		PlanEntity saveEntity=planRepo.save(planEntity);
		return saveEntity.getPlanName();
	}

	@Override
	public Integer saveCCAPPlan(CCAPPlan ccapPlan) {
		CCAPPlanEntity ccapEntity=new CCAPPlanEntity();
		ccapEntity.setCaseId(ccapPlan.getCaseId());
		ccapEntity.setIndividaulName(ccapPlan.getIndividualName());
		ccapEntity.setChildName(ccapPlan.getChildName());
		ccapEntity.setChildGender(ccapPlan.getChildGender());
		ccapEntity.setChildDob(formatDate(ccapPlan.getChildDob()));
		ccapEntity.setChildSSN(ccapPlan.getChildSSN());
		CCAPPlanEntity saveCCAP=ccapRepo.save(ccapEntity);
		return saveCCAP.getCaseId();
	}

	@Override
	public Integer saveSNAPPlan(SNAPPlan snapPlan) {
		SNAPPlanEntity snapEntity=new SNAPPlanEntity();
		BeanUtils.copyProperties(snapPlan, snapEntity);
		SNAPPlanEntity saveSNAP=snapRepo.save(snapEntity);
		return saveSNAP.getCaseId();
	}

	@Override
	public Integer saveKTWORKPlan(KTWORKPlan ktworkPlan) {
		KTWORKPlanEntity ktworkEntity=new KTWORKPlanEntity();
		ktworkEntity.setCaseId(ktworkPlan.getCaseId());
		ktworkEntity.setIndividaulName(ktworkPlan.getIndividualName());
		ktworkEntity.setQualification(ktworkPlan.getQualification());
		ktworkEntity.setEducationComleted(formatDate(ktworkPlan.getEducationComleted()));
		ktworkEntity.setGrade(ktworkPlan.getGrade());
		KTWORKPlanEntity saveKTWORK=ktworkRepo.save(ktworkEntity);
		return saveKTWORK.getCaseId();
	}

	@Override
	public String formatSSN(String ssn) {
		
		return ssn.replaceAll(",", "-");
	}  
	
	@Override
	public CCAPPlan getCCAPCaseById(Integer caseId) {
		Optional<CCAPPlanEntity> optionalEntity = ccapRepo.findById(caseId);
		CCAPPlan caseDetails = new CCAPPlan();
		if (optionalEntity.isPresent()) {
			CCAPPlanEntity caseEntity = optionalEntity.get();

			caseDetails.setIndividualName(caseEntity.getIndividaulName());
			caseDetails.setCaseId(caseEntity.getCaseId());
			caseDetails.setChildDob(formatString(caseEntity.getChildDob()));
			caseDetails.setChildName(caseEntity.getChildName());			
			caseDetails.setChildGender(caseEntity.getChildGender());	
			caseDetails.setChildSSN(caseEntity.getChildSSN());			
			return caseDetails;
		}
		return null;
	}

	@Override
	public List<CCAPPlan> getCCAPAllCase() {
		List<CCAPPlanEntity> caseEntityList=ccapRepo.findAll();
		List<CCAPPlan> caseList=new ArrayList<CCAPPlan>();
		caseEntityList.forEach(caseEntity->{
			CCAPPlan caseDetails=new CCAPPlan();
			caseDetails.setIndividualName(caseEntity.getIndividaulName());
			caseDetails.setCaseId(caseEntity.getCaseId());
			caseDetails.setChildDob(formatString(caseEntity.getChildDob()));
			caseDetails.setChildName(caseEntity.getChildName());			
			caseDetails.setChildGender(caseEntity.getChildGender());	
			caseDetails.setChildSSN(caseEntity.getChildSSN());			
			
			
			 caseList.add(caseDetails);
		});
		return caseList;
	}

	public boolean deleteCCAPPlan(Integer caseId) {
		Optional<CCAPPlanEntity> optionalEntity = ccapRepo.findById(caseId);
		
		if (optionalEntity.isPresent()) {
			CCAPPlanEntity caseEntity = optionalEntity.get();
			ccapRepo.delete(caseEntity);
			return true;
		}
		return false;
	}

}
