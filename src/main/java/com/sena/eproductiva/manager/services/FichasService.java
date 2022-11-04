package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.FichaDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.entitys.Ficha;
import com.sena.eproductiva.manager.repositories.FichasRepository;

@Service
public class FichasService {

    @Autowired
    private FichasRepository fichasRepository;

    @Autowired
    ProgramasFormacionService programasFormacionService;

    @Autowired
    CentroFormacionService centroFormacionService;

    @Autowired
    InstructorService instructorService;

    public List<Ficha> getAllFichas() {
        return fichasRepository.findAll();
    }

    public Ficha getFichaById(String id) {
        return fichasRepository.findFichaByAnyId(id).orElse(null);
    }

    public Ficha updateFicha(FichaDto fichaDto,String id) {
        Ficha ficha = getFichaById(id);
        if(Objects.isNull(ficha))
            ficha = new Ficha();
        ficha.setId(fichaDto.getId());
        ficha.setProgramaFormacionEntity(programasFormacionService.getProgramasFormacionByName(fichaDto.getProgramaId()));
        ficha.setCentroFormacionEntity(centroFormacionService.getCentroFormacionById(fichaDto.getCentroId().toString()));
        ficha.setInstructorEntity(instructorService.getInstructorByDocumento(fichaDto.getInstructor()));
        ficha.setModalidad(fichaDto.getModalidad());
        ficha.setInicio(fichaDto.getInicio());
        ficha.setFin(fichaDto.getFin());
        ficha.setEnabled(fichaDto.isEnabled());
        return fichasRepository.save(ficha);
    }

    public Ficha createFicha(FichaDto fichaDto) {
        return updateFicha( fichaDto,null);
    }

    public FichaDto transfomrDto(Ficha ficha){
        FichaDto dto = new FichaDto();
        dto.setId(ficha.getId());
        dto.setProgramaId(ficha.getProgramaFormacionEntity().getId());
        dto.setCentroId(ficha.getCentroFormacionEntity().getUuid());
        dto.setInstructor(ficha.getInstructorEntity().getDocumento());
        dto.setModalidad(ficha.getModalidad());
        dto.setInicio(ficha.getInicio());
        dto.setFin(ficha.getFin());
        dto.setEnabled(ficha.isEnabled());
        return dto;
    }

    public List<FichaDto> transformListDto(List<Ficha> fichas){
        return fichas.stream().map(this::transfomrDto).toList();
    }

    public Page<Ficha> getPageFicha(Pageable pageable){
        return fichasRepository.findAll(pageable);
    }

    public PageDto<FichaDto> getFichasDtoPage(int page, int size){
        Page<Ficha> ficha = getPageFicha(PageRequest.of(page, size));
        PageDto<FichaDto> pageDto = new PageDto<>();
        pageDto.setContent(this.transformListDto(ficha.getContent()));
        return pageDto ;
    }

    //TODO pensar como remover el mensaje de sonar 
    public boolean validateExist(FichaDto fichaDto){
        return Objects.isNull(fichaDto.getId())||
            Objects.isNull(fichaDto.getCentroId())||
            Objects.isNull(fichaDto.getProgramaId())||
            Objects.isNull(fichaDto.getInstructor());
    }

    public void disabledFicha(String id) {
        Ficha ficha = this.getFichaById(id);
        ficha.setEnabled(false);
        fichasRepository.save(ficha);
    }
}