package com.ashokit.ies.ed.binding;

import lombok.Data;

@Data
public class EDRuleResponse {
	private String planName;
	private String planStatus;
	
	private String planStartDate;
	private String planEndDate;
	private String benefitAmt;
	
	private String denialReason;
}
