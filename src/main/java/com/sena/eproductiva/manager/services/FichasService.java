package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.FichaDto;
import com.sena.eproductiva.manager.models.entitys.FichaEntity;
import com.sena.eproductiva.manager.repositories.FichasRepository;

@Service
public class FichasService {

    @Autowired
    private FichasRepository fichasRepository;

    public List<FichaEntity> getAllFichas() {
        return fichasRepository.findAll();
    }

    public Optional<FichaEntity> getFichaById(long id) {
        return fichasRepository.findById(id);
    }

    public FichaEntity updateFicha(FichaEntity fichasEntity) {
        return fichasRepository.save(fichasEntity);
    }

    public FichaEntity createFicha(FichaEntity fichasEntity) {
        return fichasRepository.save(fichasEntity);
    }

    public void deleteFichaById(long id) {
        fichasRepository.deleteById(id);
    }
    public List<FichaDto> getAllFichaDtos(){
        return this.getAllFichas().stream().map(ficha ->{
            FichaDto dto = new FichaDto();
            dto.setId(ficha.getId());
            dto.setProgramaId(ficha.getProgramaFormacionEntity().getId());
            dto.setModalidad(ficha.getModalidad());
            dto.setInstructorCc(ficha.getInstructorEntity().getCc());
            dto.setCentroId(ficha.getCentroFormacionEntity().getUuid());
            dto.setInicio(ficha.getInicio());
            dto.setFin(ficha.getFin());
            dto.setEnabled(ficha.isEnabled());
            return dto;
        }).collect(Collectors.toList());
    }
    // public Optional<FichaDto> getFichaDtoById(long id){
    //     return this.getFichaById(id).stream().map(ficha ->{
    //         FichaDto dto = new FichaDto();
    //         dto.getId(ficha.getId());
    //         return dto;
    //     }).collect(Collectors.toList());
    // }

}
