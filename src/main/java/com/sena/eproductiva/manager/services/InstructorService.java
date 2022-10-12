package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.entitys.InstructorEntity;
import com.sena.eproductiva.manager.repositories.InstructorRepository;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    
    public List<InstructorEntity> getAllInstructores(){
        return instructorRepository.findAll();
    } 

    public Optional<InstructorEntity> getInstructorById(long id){
        return  instructorRepository.findById(id);
    }

    public InstructorEntity updateInstructor(InstructorEntity instructorEntity){
        return instructorRepository.save(instructorEntity); 
    }

    public InstructorEntity createInstructor(InstructorEntity instructorEntity){
        return instructorRepository.save(instructorEntity);
    }

    public void deleteInstructorById(long id){
        instructorRepository.deleteById(id);
    }

}
