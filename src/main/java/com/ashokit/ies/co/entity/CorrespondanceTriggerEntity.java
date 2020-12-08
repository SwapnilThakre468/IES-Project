package com.ashokit.ies.co.entity;

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
@Table(name="CO_TRIGGERS")
public class CorrespondanceTriggerEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TRG_ID")
	Integer trgId ;
	@Column(name="CASE_ID")
	Integer caseId; 
	@Column(name="CREATE_DATE")
	Date createDate;
	@Column(name="TRG_STATUS")
	String trgStatus;
	@Column(name="UPDATE_DATE")
	Date updateDate;
}
