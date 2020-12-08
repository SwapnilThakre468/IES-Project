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
@Table(name = "DHS_EMPLOYEE")
public class DHSEmployeeAccountEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Employee_ID",unique=true,nullable=false , updatable=false)
	private Integer employeeId;
	@Column(name = "FIRST_NAME")
    private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "DOB")
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "SSN")
	private String ssn;
	@Column(name = "PHONE_NO")
	private String phoneNo;
	@Column(name = "ROLE")
	private String role;
	@Column(name="STATUS")
	private String status;
}
