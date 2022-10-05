package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dao.entitys.FichasEntity;
import com.sena.eproductiva.manager.repositories.FichasRepository;

@Service
public class FichasService {

    @Autowired
    private FichasRepository fichasRepository;

    public List<FichasEntity> getAllFichas() {
        return fichasRepository.findAll();
    }

    public Optional<FichasEntity> getFichaById(long id) {
        return fichasRepository.findById(id);
    }

    public FichasEntity updateFicha(FichasEntity fichasEntity) {
        return fichasRepository.save(fichasEntity);
    }

    public FichasEntity createFicha(FichasEntity fichasEntity) {
        return fichasRepository.save(fichasEntity);
    }

    public void deleteFichaById(long id) {
        fichasRepository.deleteById(id);
    }
}
