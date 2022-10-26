package com.sena.eproductiva.manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sena.eproductiva.manager.models.entitys.Centro;

@Repository
public interface CentroFormacionRepository extends JpaRepository<Centro, Long>, JpaSpecificationExecutor<Centro> {

        @Query(value="select c from Centro c where c.nombre = :id")
        public Optional<Centro> findByName(@Param("id") Long id);
}