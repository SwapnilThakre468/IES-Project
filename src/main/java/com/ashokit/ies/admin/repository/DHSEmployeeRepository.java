package com.ashokit.ies.admin.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashokit.ies.admin.entity.DHSEmployeeAccountEntity;

public interface DHSEmployeeRepository extends JpaRepository<DHSEmployeeAccountEntity, Serializable> {
                List<DHSEmployeeAccountEntity> findByRole(String role);

				DHSEmployeeAccountEntity findByEmail(String email);
                
}
