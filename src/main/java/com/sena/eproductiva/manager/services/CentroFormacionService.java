package com.sena.eproductiva.manager.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sena.eproductiva.manager.models.dao.entitys.CentroFormacionEntity;
import com.sena.eproductiva.manager.repositories.CentroFormacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CentroFormacionService {
    @Autowired
    CentroFormacionRepository centroFormacionRepository;

    public List<CentroFormacionEntity> getAllCentroFormacion(){
        return (List<CentroFormacionEntity>) centroFormacionRepository.findAll();
    } 
    public Optional<CentroFormacionEntity> getCentroFormacionById(long id){
        return  centroFormacionRepository.findById(id);
    }
}
