package com.sena.eproductiva.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dao.entitys.ProgramaFormacionEntity;
import com.sena.eproductiva.manager.repositories.ProgramasFormacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramasFormacionService {
    @Autowired
    private ProgramasFormacionRepository programasFormacionRepository;

    public List<ProgramaFormacionEntity> getAllProgramasFormacion() {
        return programasFormacionRepository.findAll();
    }

    public Optional<ProgramaFormacionEntity> getProgramasFormacionById(long id) {
        return programasFormacionRepository.findById(id);
    }

    public ProgramaFormacionEntity updateFicha(ProgramaFormacionEntity programasFormacionEntity) {
        return programasFormacionRepository.save(programasFormacionEntity);
    }

    public ProgramaFormacionEntity createFicha(ProgramaFormacionEntity programasFormacionEntity) {
        return programasFormacionRepository.save(programasFormacionEntity);
    }

    public void deleteFichaById(long id) {
        programasFormacionRepository.deleteById(id);
    }
}
