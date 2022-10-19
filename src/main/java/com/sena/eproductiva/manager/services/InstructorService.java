package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.InstructorDto;
import com.sena.eproductiva.manager.models.entitys.Instructor;
import com.sena.eproductiva.manager.repositories.InstructorRepository;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    
    public List<Instructor> getAllInstructores(){
        return instructorRepository.findAll();
    } 

    public Optional<Instructor> getInstructorById(long id){
        return  instructorRepository.findById(id);
    }

    public Instructor updateInstructor(Instructor instructorEntity){
        return instructorRepository.save(instructorEntity); 
    }

    public Instructor createInstructor(Instructor instructorEntity){
        return instructorRepository.save(instructorEntity);
    }

    public void deleteInstructorById(long id){
        instructorRepository.deleteById(id);
    }

    public List<InstructorDto> getAllInstructorDtos(){
        return this.getAllInstructores().stream().map(instructor ->{
            InstructorDto dto = new InstructorDto();
            dto.setCc(instructor.getCc());
            dto.setNombre(instructor.getNombre());
            dto.setApellido(instructor.getApellido());
            dto.setEmail(instructor.getEmail());
            dto.setTelefono(instructor.getTelefono());
            dto.setCentroId(instructor.getCentroFormacionEntity().getUuid());
            dto.setEnabled(instructor.isEnabled());
            return dto;
        }).collect(Collectors.toList());
    }

}
