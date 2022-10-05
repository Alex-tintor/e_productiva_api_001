package com.sena.eproductiva.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sena.eproductiva.manager.models.dao.entitys.AprendicesEntity;

@Repository
public interface AprendicesRepository extends JpaRepository<AprendicesEntity, Long>, JpaSpecificationExecutor<AprendicesEntity> {
    
}
