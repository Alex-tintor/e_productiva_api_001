package com.sena.eproductiva.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.sena.eproductiva.manager.models.entitys.Centro;

@Repository
public interface CentroFormacionRepository
        extends JpaRepository<Centro, Long>, JpaSpecificationExecutor<Centro> {

}