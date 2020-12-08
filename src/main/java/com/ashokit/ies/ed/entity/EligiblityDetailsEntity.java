package com.ashokit.ies.ed.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity 
@Table(name="ELIGIBLITY_DETAILS")
public class EligiblityDetailsEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ED_TRACE_ID")
	Integer edTraceId ;
	@Column(name="BENEFIT_AMT")
    String benefitAmt;
	@Column(name="CASE_ID")
    Integer caseId ;
	@Column(name="CREATE_DATE")
    Date createDate;
	@Column(name="DENIAL_REASON")
    String denialReason ;
	@Column(name="PLAN_END_DATE")
    Date  planEndDate ;
	@Column(name="PLAN_NAME")
    String planName ;
	@Column(name="PLAN_START_DATE")
    Date planStartDate ;
	@Column(name="PLAN_STATUS")
    String planStatus ; 
	@Column(name="UPDATE_DATE")
	Date  updateDate;
    
}
