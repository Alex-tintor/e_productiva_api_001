package com.sena.eproductiva.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sena.eproductiva.manager.models.dao.entitys.InstructorEntity;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorEntity, Long>, JpaSpecificationExecutor<InstructorEntity> {
    
}