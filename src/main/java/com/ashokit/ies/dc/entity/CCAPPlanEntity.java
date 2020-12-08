package com.ashokit.ies.dc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="DC_CCAP")
public class CCAPPlanEntity {
	@Id
	@Column(name="CASE_ID")
	private Integer caseId;
	@Column(name="INDIVIDAUL_NAME")
    private String individaulName;
	@Column(name="CHILD_NAME")
    private String childName;
	@Column(name="CHILD_GENDER")
    private String childGender;
	@Column(name="CHILD_DOB")
    private Date childDob;
	@Column(name="CHILD_SSN")
    private String childSSN;
}
