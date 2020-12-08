package com.ashokit.ies.ar.domain;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class ApplicationRegistration {
	
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
