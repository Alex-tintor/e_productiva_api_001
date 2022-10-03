package com.sena.eproductiva.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dao.entitys.ProgramasFormacionEntity;
import com.sena.eproductiva.manager.repositories.ProgramasFormacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramasFormacionService {
    @Autowired
    ProgramasFormacionRepository programasFormacionRepository;

    public List<ProgramasFormacionEntity> getAllProgramasFormacion(){
        return (List<ProgramasFormacionEntity>) programasFormacionRepository.findAll();
    }

    public Optional<ProgramasFormacionEntity> getProgramasFormacionById(long id){
        return programasFormacionRepository.findById(id);
    }

    public  List<ProgramasFormacionEntity> updateFicha(ProgramasFormacionEntity programasFormacionEntity){
        return (List<ProgramasFormacionEntity>) programasFormacionRepository.save(programasFormacionEntity); 
    }

    public List<ProgramasFormacionEntity> createFicha(ProgramasFormacionEntity programasFormacionEntity){
        return (List<ProgramasFormacionEntity>) programasFormacionRepository.save(programasFormacionEntity);
    }

    public Optional<ProgramasFormacionEntity> deleteFichaById(long id){
        programasFormacionRepository.deleteById(id);
        return null;
    }
}
