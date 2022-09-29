package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dao.entitys.FormatoEntity;
import com.sena.eproductiva.manager.repositories.FormatoRepository;

@Service
public class FormatoService {
    @Autowired
    FormatoRepository formatoRepository;

    public List<FormatoEntity> getAllFormato(){
        return (List<FormatoEntity>) formatoRepository.findAll();
    } 
    public Optional<FormatoEntity> getFormatoById(long id){
        return  formatoRepository.findById(id);
    }
}
