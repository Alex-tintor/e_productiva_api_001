package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.entitys.FormatoEntity;
import com.sena.eproductiva.manager.repositories.FormatoRepository;

@Service
public class FormatoService {

    @Autowired
    private FormatoRepository formatoRepository;

    public List<FormatoEntity> getAllFormato(){
        return formatoRepository.findAll();
    } 

    public Optional<FormatoEntity> getFormatoById(long id){
        return  formatoRepository.findById(id);
    }

    public FormatoEntity updateFormato(FormatoEntity formatosEntity){
        return formatoRepository.save(formatosEntity); 
    }

    public FormatoEntity createFormato(FormatoEntity formatoEntity){
        return formatoRepository.save(formatoEntity);
    }

    public void deleteFormatoById(long id){
        formatoRepository.deleteById(id);
    }
}
