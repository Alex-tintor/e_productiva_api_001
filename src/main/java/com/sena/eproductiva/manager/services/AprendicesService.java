package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dao.entitys.AprendicesEntity;
import com.sena.eproductiva.manager.repositories.AprendicesRepository;

@Service
public class AprendicesService {
    
    @Autowired
    private AprendicesRepository aprendicesRepository;

    public List<AprendicesEntity> getAllPrendices(){
        return aprendicesRepository.findAll();
    }

    public Optional<AprendicesEntity> getAprendicesById(long id){
        return aprendicesRepository.findById(id);
    }

    public AprendicesEntity updateAprendiz(AprendicesEntity aprendicesEntity){
        return aprendicesRepository.save(aprendicesEntity);
    }

    public AprendicesEntity createAprendiz(AprendicesEntity aprendicesEntity){
        return aprendicesRepository.save(aprendicesEntity);
    }

    public void deleteAprendiz(long id){
        aprendicesRepository.deleteById(id);
    }
}
