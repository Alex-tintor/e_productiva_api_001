package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.entitys.Formato;
import com.sena.eproductiva.manager.repositories.FormatoRepository;

@Service
public class FormatoService {

    @Autowired
    private FormatoRepository formatoRepository;

    public List<Formato> getAllFormato(){
        return formatoRepository.findAll();
    } 

    public Optional<Formato> getFormatoById(long id){
        return  formatoRepository.findById(id);
    }

    public Formato updateFormato(Formato formatosEntity){
        return formatoRepository.save(formatosEntity); 
    }

    public Formato createFormato(Formato formatoEntity){
        return formatoRepository.save(formatoEntity);
    }

    public void deleteFormatoById(long id){
        formatoRepository.deleteById(id);
    }
}
