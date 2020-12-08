package com.ashokit.ies.dc.service;

import java.util.Date;
import java.util.List;

import com.ashokit.ies.dc.domain.CCAPPlan;
import com.ashokit.ies.dc.domain.CaseDetails;
import com.ashokit.ies.dc.domain.KTWORKPlan;
import com.ashokit.ies.dc.domain.Plan;
import com.ashokit.ies.dc.domain.SNAPPlan;

public interface CaseService  {
     public CaseDetails bringARDetails(String appId);
     public Integer saveCaseDetails(CaseDetails  caseDetails);
     public boolean changeCaseStatus(Integer caseId);
     public CaseDetails getCaseById(Integer caseId);
     public List<CaseDetails> getAllCase();
     public String formatString(Date date);
 	 public Date formatDate(String date);
     public List<String> getPlanList();
     public String saveCasePlan(Plan casePlan);
     public Integer saveCCAPPlan(CCAPPlan ccapPlan);
     public Integer saveSNAPPlan(SNAPPlan snapPlan);
     public Integer saveKTWORKPlan(KTWORKPlan ktworkPlan);
     public String formatSSN(String ssn);
	 public CCAPPlan getCCAPCaseById(Integer caseId);
	 public List<CCAPPlan> getCCAPAllCase();
	 public boolean deleteCCAPPlan(Integer caseId);
}
