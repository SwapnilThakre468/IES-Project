package com.ashokit.ies.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_SNAP")
public class SNAPPlanEntity {
	@Id
	@Column(name="CASE_ID")
	 private Integer caseId;
	@Column(name="INDIVIDAUL_NAME")
     private String individaulName;
	@Column(name="EMPLOYEED")
     private boolean employeed;
	@Column(name="OTHER_INCOME")
     private Double otherIncome;
}
