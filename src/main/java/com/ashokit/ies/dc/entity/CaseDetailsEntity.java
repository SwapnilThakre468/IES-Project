package com.ashokit.ies.dc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;



import lombok.Data;
@Data
@Entity
@Table(name="DC_Cases")
public class CaseDetailsEntity {
      
	@Id	
	@GenericGenerator(name="DC_ID_GEN" ,strategy="com.ashokit.ies.dc.generator.CaseIDGenerator" )
	@GeneratedValue(generator="DC_ID_GEN" )
	@Column(name="CASE_ID")
	private Integer caseId;
	@Column(name="APP_ID")
	private String appId;
	@Column(name="FIRST_NAME")
	private String firstName;
	@Column(name="LAST_NAME")
	private String lastName;
	@Column(name="DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name="GENDER")
	private String gender;
	@Column(name="SSN")
	private String ssn;
	@Column(name="PHONE_NO")
	private String phoneNo;
	@Column(name="EMAIL")
	private String email;
	@Column(name="STATUS")
	private String status;
}
