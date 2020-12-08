package com.ashokit.ies.admin.domain;



import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DHSPlan {
	private Integer planId;
	private String planName;
	private String planDescrp;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private String startDate;
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private String endDate;
	private String status;
}
