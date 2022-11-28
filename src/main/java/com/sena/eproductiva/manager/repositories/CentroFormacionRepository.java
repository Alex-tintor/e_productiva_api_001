package com.sena.eproductiva.manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sena.eproductiva.manager.models.entitys.Centro;

@Repository
public interface CentroFormacionRepository extends JpaRepository<Centro, String>, JpaSpecificationExecutor<Centro> {

        /**
         * Metodo que devuelve un registro de la entidad Centro por medio de un id,
         * ejecuta el @Query
         * 
         * @param id recibe un identificador unico de Centro
         * @return retorna todo de Centro
         */
        @Query(value = "select c from Centro c where c.nombre = :id or c.uuid = :id")
        public Optional<Centro> findByName(@Param("id") String id);

}