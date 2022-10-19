package com.sena.eproductiva.manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.sena.eproductiva.manager.models.entitys.FormatoEntity;

@Repository
public interface FormatoRepository extends JpaRepository<FormatoEntity, Long>, JpaSpecificationExecutor<FormatoEntity> {
}