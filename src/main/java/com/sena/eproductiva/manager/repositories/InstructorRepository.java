package com.sena.eproductiva.manager.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sena.eproductiva.manager.models.entitys.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, String>, JpaSpecificationExecutor<Instructor> {

    /**
     * Metodo que retorna todo de un registro en la entidad Instructor por medio de
     * 3 opciones de datos
     * 
     * @param documento dato para consultar a el Instructor,
     *                  documento-telefono-email
     * @return retorna todo de Instructor
     */
    @Query(value = "select i from Instructor i where i.documento = :documento or i.telefono = :documento or i.email = :documento")
    public Optional<Instructor> findByDocumento(@Param("documento") String documento);
}