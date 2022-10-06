package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dao.entitys.AprendizEntity;
import com.sena.eproductiva.manager.repositories.AprendicesRepository;

@Service
public class AprendicesService {
    
    @Autowired
    private AprendicesRepository aprendicesRepository;

    public List<AprendizEntity> getAllPrendices(){
        return aprendicesRepository.findAll();
    }

    public Optional<AprendizEntity> getAprendicesById(long id){
        return aprendicesRepository.findById(id);
    }

    public AprendizEntity updateAprendiz(AprendizEntity aprendicesEntity){
        return aprendicesRepository.save(aprendicesEntity);
    }

    public AprendizEntity createAprendiz(AprendizEntity aprendicesEntity){
        return aprendicesRepository.save(aprendicesEntity);
    }

    public void deleteAprendiz(long id){
        aprendicesRepository.deleteById(id);
    }
}
