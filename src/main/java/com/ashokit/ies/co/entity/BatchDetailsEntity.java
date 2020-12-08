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
@Table(name = "BATCH_RUN_DTLS")
public class BatchDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "BATCH_RUN_SEQ")
	Integer batchRunSeq;
	@Column(name = "BATCH_NAME")
	String batchName;
	@Column(name = "BATCH_RUN_STATUS")
	String batchRunStatus;
	@Column(name = "END_DATE")
	Date endDate;
	@Column(name = "INSTANCE_NUM")
	Integer instanceNum;
	@Column(name = "START_DATE")
	Date startDate;
}
