package com.sena.eproductiva.manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sena.eproductiva.manager.models.entitys.Programa;

@Repository
public interface ProgramasFormacionRepository
                extends JpaRepository<Programa, Long>, JpaSpecificationExecutor<Programa> {

        /**
         * Metodo para consultar un Programa por medio de 2 opciones
         * 
         * @param id recibe el nombre o id del programa
         * @return retorna todo de Programa
         */
        @Query(value = "select p from Programa p where p.nombre = :id or p.id = :id")
        public Optional<Programa> findByNombre(@Param("id") String id);
}