package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dao.entitys.FichasEntity;
import com.sena.eproductiva.manager.repositories.FichasRepository;

@Service
public class FichasService {

    @Autowired
    FichasRepository fichasRepository;

    public List<FichasEntity> getAllFichas(){
        return (List<FichasEntity>) fichasRepository.findAll();
    }

    public Optional<FichasEntity> getFichaById(long id){
        return fichasRepository.findById(id);
    }
    
    public  List<FichasEntity> updateFicha(FichasEntity fichasEntity){
        return (List<FichasEntity>) fichasRepository.save(fichasEntity); 
    }

    public List<FichasEntity> createFicha(FichasEntity fichasEntity){
        return (List<FichasEntity>) fichasRepository.save(fichasEntity);
    }

    public Optional<FichasEntity> deleteFichaById(long id){
        fichasRepository.deleteById(id);
        return null;
    }
}
