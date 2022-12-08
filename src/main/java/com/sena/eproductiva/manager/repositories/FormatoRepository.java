package com.sena.eproductiva.manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sena.eproductiva.manager.models.entitys.Formato;

@Repository
public interface FormatoRepository extends JpaRepository<Formato, Long>, JpaSpecificationExecutor<Formato> {

    /**
     * Metodo que retorna todo de un registro en la entidad Formato por medio de 2
     * opciones de datos
     * 
     * @param documento dato a consultar, opciones (documento del Instructor o id
     *                  del Formato)
     * @return retorna todo de la entidad Formato
     */
    @Query(value = "select f from Formato f where f.instructor.documento = :documento or f.id = :documento")
    public Optional<Formato> findByInstructorDocument(@Param("documento") String documento);
}