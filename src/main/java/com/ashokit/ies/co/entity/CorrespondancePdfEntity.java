package com.ashokit.ies.co.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="CO_PDFS")
public class CorrespondancePdfEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CO_PDF_ID")
	Integer coPdfId; 
	@Column(name="PLAN_STATUS")
	String planStatus; 
	@Column(name="CASE_ID")
	Integer caseId;   
	@Column(name="PDF_DOCUMENT")
	Blob pdfDocument;
	@Column(name="PLAN_NAME")
	String planName;            
}
