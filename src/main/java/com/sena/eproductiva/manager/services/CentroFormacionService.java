package com.sena.eproductiva.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.CentroFormacionDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.entitys.Centro;
import com.sena.eproductiva.manager.repositories.CentroFormacionRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class CentroFormacionService {

    @Autowired
    private CentroFormacionRepository centroFormacionRepository;

    public List<Centro> getAllCentroFormacion() {
        return centroFormacionRepository.findAll();
    }

    public Centro getCentroFormacionById(String id) {
        return centroFormacionRepository.findByName(id).orElse(null);
    }

    public Centro updateCentro(CentroFormacionDto centroFormacionDto,String id) {
        Centro centro = this.getCentroFormacionById(id);
        if(Objects.isNull(centro))
            centro = new Centro();
        centro.setUuid(centroFormacionDto.getUuid());
        centro.setNombre(centroFormacionDto.getNombre());
        centro.setEnabled(centroFormacionDto.isEnabled());
        return centroFormacionRepository.save(centro);
    }

    public Centro createCentro(CentroFormacionDto centroFormacionDto) {
        return updateCentro(centroFormacionDto, null);
    }

    public CentroFormacionDto transformDto(Centro centro){
        CentroFormacionDto dto = new CentroFormacionDto();
        dto.setUuid(centro.getUuid());
        dto.setNombre(centro.getNombre());
        dto.setEnabled(centro.isEnabled());
        return dto;
    }

    public List<CentroFormacionDto> transformListDtos(List<Centro> centros){
        return centros.stream().map(this::transformDto).collect(Collectors.toList());
    }

    public Page<Centro> getPageCentro(Pageable pageable){
        return centroFormacionRepository.findAll(pageable);
    }

    public PageDto<CentroFormacionDto> getPageDtoCentro(int page, int size){
        Page<Centro> centro = getPageCentro(PageRequest.of(page, size));
        PageDto<CentroFormacionDto> pageDto = new PageDto<>();
        pageDto.setContent(this.transformListDtos(centro.getContent()));
        return pageDto;
    }

    public boolean validateExist(CentroFormacionDto centro){
        return Objects.isNull(centro.getNombre())||
            Objects.isNull(centro.getUuid());
    }

    public void disableCentro(String id){
        Centro centro = this.getCentroFormacionById(id);
        centro.setEnabled(false);
        centroFormacionRepository.save(centro);
    }

}