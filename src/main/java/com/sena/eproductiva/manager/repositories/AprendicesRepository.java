package com.sena.eproductiva.manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sena.eproductiva.manager.models.entitys.Aprendiz;

@Repository
public interface AprendicesRepository extends JpaRepository<Aprendiz, String>, JpaSpecificationExecutor<Aprendiz> {

        @Query(value = "select a from Aprendiz a where a.documento = :documento or a.telefono = :documento or a.email = :documento")
        public Optional<Aprendiz> findByDocumento(@Param("documento") String documento);
}