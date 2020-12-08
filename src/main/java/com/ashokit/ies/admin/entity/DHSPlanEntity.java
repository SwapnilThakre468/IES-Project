package com.ashokit.ies.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="DHS_PLAN")
public class DHSPlanEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PLAN_ID",unique=true,nullable=false , updatable=false)
	private Integer planId;
	@Column(name="PLAN_NAME")
	private String planName;
	@Column(name="PLAN_DESCRP")
	private String planDescrp;
	@Column(name="START_DATE")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name="END_DATE")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Column(name="STATUS")
	private String status;
}
