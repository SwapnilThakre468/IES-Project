package com.ashokit.ies.ar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashokit.ies.ar.entity.AREntity;
@Repository
public interface ARRepository extends JpaRepository<AREntity, Serializable> {

}
