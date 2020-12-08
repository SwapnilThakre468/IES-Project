package com.ashokit.ies.dc.domain;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class CaseDetails {
	private Integer caseId;
	private String appId;	
	private String firstName;
	private String lastName;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private String dob;
	private String gender;
	private String ssn;
	private String phoneNo;
	private String email;
	private String status;
}
