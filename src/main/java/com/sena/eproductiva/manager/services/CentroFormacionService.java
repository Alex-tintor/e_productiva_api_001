package com.sena.eproductiva.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.entitys.CentroFormacionEntity;
import com.sena.eproductiva.manager.repositories.CentroFormacionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CentroFormacionService {
    @Autowired
    private CentroFormacionRepository centroFormacionRepository;

    public List<CentroFormacionEntity> getAllCentroFormacion() {
        return centroFormacionRepository.findAll();
    }

    public Optional<CentroFormacionEntity> getCentroFormacionById(long id) {
        return centroFormacionRepository.findById(id);
    }

    public CentroFormacionEntity updateCentro(CentroFormacionEntity centroFormacionEntity) {
        return centroFormacionRepository.save(centroFormacionEntity);
    }

    public CentroFormacionEntity createCentro(CentroFormacionEntity centroFormacionEntity) {
        return centroFormacionRepository.save(centroFormacionEntity);
    }

    public void deleteCentro(long id) {
        centroFormacionRepository.deleteById(id);
    }

}