package com.ashokit.ies.dc.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.dc.entity.PlanEntity;

public interface CasePlanRepository extends JpaRepository<PlanEntity, Integer> {

	
}
