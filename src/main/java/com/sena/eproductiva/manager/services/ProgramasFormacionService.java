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
    private ProgramasFormacionRepository programasFormacionRepository;

    public List<ProgramasFormacionEntity> getAllProgramasFormacion() {
        return programasFormacionRepository.findAll();
    }

    public Optional<ProgramasFormacionEntity> getProgramasFormacionById(long id) {
        return programasFormacionRepository.findById(id);
    }

    public ProgramasFormacionEntity updateFicha(ProgramasFormacionEntity programasFormacionEntity) {
        return programasFormacionRepository.save(programasFormacionEntity);
    }

    public ProgramasFormacionEntity createFicha(ProgramasFormacionEntity programasFormacionEntity) {
        return programasFormacionRepository.save(programasFormacionEntity);
    }

    public void deleteFichaById(long id) {
        programasFormacionRepository.deleteById(id);
    }
}
