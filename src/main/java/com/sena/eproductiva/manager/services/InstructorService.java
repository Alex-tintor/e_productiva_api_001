package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dao.entitys.InstructorEntity;
import com.sena.eproductiva.manager.repositories.InstructorRepository;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    
    public List<InstructorEntity> getAllFormato(){
        return instructorRepository.findAll();
    } 

    public Optional<InstructorEntity> getFormatoById(long id){
        return  instructorRepository.findById(id);
    }

    public InstructorEntity updateFormato(InstructorEntity instructorEntity){
        return instructorRepository.save(instructorEntity); 
    }

    public InstructorEntity createFormato(InstructorEntity instructorEntity){
        return instructorRepository.save(instructorEntity);
    }

    public void deleteFormatoById(long id){
        instructorRepository.deleteById(id);
    }

}
