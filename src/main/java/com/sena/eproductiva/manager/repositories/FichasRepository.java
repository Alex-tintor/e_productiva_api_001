package com.sena.eproductiva.manager.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.eproductiva.manager.models.dao.entitys.FichasEntity;

@Repository
public interface FichasRepository extends CrudRepository<FichasEntity, Long>{
    
}
