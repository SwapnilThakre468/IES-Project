package com.ashokit.ies.dc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="DC_KTWORK")
public class KTWORKPlanEntity {
	@Id
	@Column(name="CASE_ID")
	 private Integer caseId;
	@Column(name="INDIVIDAUL_NAME")
     private String individaulName;
	@Column(name="QUALIFICATION")
     private String qualification;
	@Column(name="EDUCATION_COMPLETED")
	@Temporal(TemporalType.DATE)
     private Date educationComleted;
	@Column(name="GRADE")
     private String grade;
}
