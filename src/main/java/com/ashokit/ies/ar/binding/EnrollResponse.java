package com.ashokit.ies.ar.binding;

import java.util.Date;



import lombok.Data;
@Data

public class EnrollResponse {
	private String firstName; 
	private String lastName;
	private Date dob;
	private String state;
	private String ssn;
}
