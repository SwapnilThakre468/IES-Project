package com.ashokit.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.dc.entity.CaseDetailsEntity;

public interface CaseRepository extends JpaRepository<CaseDetailsEntity, Serializable> {

	

}
