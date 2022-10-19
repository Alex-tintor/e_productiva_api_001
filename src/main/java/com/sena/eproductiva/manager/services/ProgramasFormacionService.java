package com.sena.eproductiva.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.entitys.Programa;
import com.sena.eproductiva.manager.repositories.ProgramasFormacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramasFormacionService {
    @Autowired
    private ProgramasFormacionRepository programasFormacionRepository;

    public List<Programa> getAllProgramasFormacion() {
        return programasFormacionRepository.findAll();
    }

    public Optional<Programa> getProgramasFormacionById(long id) {
        return programasFormacionRepository.findById(id);
    }

    public Programa updateFicha(Programa programasFormacionEntity) {
        return programasFormacionRepository.save(programasFormacionEntity);
    }

    public Programa createFicha(Programa programasFormacionEntity) {
        return programasFormacionRepository.save(programasFormacionEntity);
    }

    public void deleteFichaById(long id) {
        programasFormacionRepository.deleteById(id);
    }
}
