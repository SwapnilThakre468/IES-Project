package com.ashokit.ies.admin.domain;



import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class DHSEmployeeAccount {
	private Integer employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private String dob;
	
	private String gender;
	
	private String ssn;
	
	private String phoneNo;
	
	private String role;
	
	private String status;
}
