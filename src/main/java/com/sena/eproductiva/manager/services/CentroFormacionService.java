package com.sena.eproductiva.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.CentroFormacionDto;
import com.sena.eproductiva.manager.models.entitys.Centro;
import com.sena.eproductiva.manager.repositories.CentroFormacionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CentroFormacionService {
    @Autowired
    private CentroFormacionRepository centroFormacionRepository;

    public List<Centro> getAllCentroFormacion() {
        return centroFormacionRepository.findAll();
    }

    public Centro getCentroFormacionById(long id) {
        return centroFormacionRepository.findById(id).orElse(null);
    }

    public Centro updateCentro(Centro centroFormacionEntity) {
        return centroFormacionRepository.save(centroFormacionEntity);
    }

    public Centro createCentro(Centro centroFormacionEntity) {
        return centroFormacionRepository.save(centroFormacionEntity);
    }

    public void deleteCentro(long id) {
        centroFormacionRepository.deleteById(id);
    }

    public List<CentroFormacionDto> getAllCentroFormacionDtos() {
        return this.getAllCentroFormacion().stream().map(centro -> {
            CentroFormacionDto dto = new CentroFormacionDto();
            dto.setUuid(centro.getUuid());
            dto.setNombre(centro.getNombre());
            dto.setEnabled(centro.isEnabled());
            return dto;
        }).collect(Collectors.toList());
    }

}