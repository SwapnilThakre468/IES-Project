package com.ashokit.ies.dc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="DC_PLAN")
public class PlanEntity {
	@Id
	@Column(name="CASE_ID")
	public Integer caseId;
	@Column(name="FIRST_NAME")
    public String firstName;
	@Column(name="LAST_NAME")
    public String lastName;
	@Column(name="PLAN_NAME")
    public String planName;
    
}
