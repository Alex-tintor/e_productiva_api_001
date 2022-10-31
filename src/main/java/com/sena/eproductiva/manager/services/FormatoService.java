package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.FormatoDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.dto.UserDto;
import com.sena.eproductiva.manager.models.entitys.Formato;
import com.sena.eproductiva.manager.models.entitys.Usuario;
import com.sena.eproductiva.manager.repositories.FormatoRepository;


@Service
public class FormatoService {

    @Autowired
    private FormatoRepository formatoRepository;

    @Autowired
    private InstructorService instructorService;


    public List<Formato> getAllFormato(){
        return formatoRepository.findAll();
    } 

    public Formato getFormatoById(Long id){
        // return  formatoRepository.findByInstructor(id).orElse(null);
        return formatoRepository.findById(id).orElse(null);
    }

    public Formato updateFormato(FormatoDto formatoDto, Long id){
        Formato formato = this.getFormatoById(id);
        if(Objects.isNull(formato))
            formato = new Formato();
        formato.setId(formatoDto.getId());
        formato.setFecha(formatoDto.getFecha());
        formato.setInstructor(instructorService.getInstructorByDocumento(formatoDto.getInstructor()));
        return formatoRepository.save(formato);
    }

    public Formato createFormato(FormatoDto formatoDto){
        return updateFormato(formatoDto, null);
    }

    public FormatoDto transformDto(Formato formato){
        FormatoDto dto = new FormatoDto();
        dto.setId(formato.getId());
        dto.setFecha(formato.getFecha());
        dto.setInstructor(formato.getInstructor().getDocumento());
        return dto;
    }

    public List<FormatoDto> transformListDtos(List<Formato> formatos){
        return formatos.stream().map(this::transformDto).toList();
    }

    public Page<Formato> getPageFormato(Pageable pageable){
        return formatoRepository.findAll(pageable);
    }

    public PageDto<FormatoDto> getPageDtoFormato(int page, int size){
        Page<Formato> formato = getPageFormato(PageRequest.of(page, size));
        PageDto<FormatoDto> pageDto = new PageDto<>();
        pageDto.setContent(this.transformListDtos(formato.getContent()));
        return pageDto;
    }

    public boolean validateExist(FormatoDto formatoDto){
        return Objects.isNull(formatoDto.getId());
    }

}
