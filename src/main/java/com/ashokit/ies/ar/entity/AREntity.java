package com.ashokit.ies.ar.entity;

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
@Table(name="APPLICATION_REGISTRATION")
public class AREntity {
@Id	
@GenericGenerator(name="AR_ID_GEN" ,strategy="com.ashokit.ies.ar.generator.ApplicationGenerator" )
@GeneratedValue(generator="AR_ID_GEN" )
@Column(name="APP_ID",unique=true,nullable=false)
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
