package com.sena.eproductiva.manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sena.eproductiva.manager.models.entitys.Ficha;

@Repository
 public interface FichasRepository extends JpaRepository<Ficha, Long>, JpaSpecificationExecutor<Ficha> {

     @Query(value = "select f from Ficha f where f.id = :id ")
     public Optional<Ficha> findFichaByAnyId(@Param("id")String id);
}