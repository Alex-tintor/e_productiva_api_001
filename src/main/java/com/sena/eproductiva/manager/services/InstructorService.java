package com.sena.eproductiva.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.InstructorDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.entitys.Instructor;
import com.sena.eproductiva.manager.repositories.InstructorRepository;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getInstructores() {
        return instructorRepository.findAll();
    }

    public Instructor getInstructorByUUID(String uuid) {
        return instructorRepository.findById(uuid).orElse(null);
    }

    public Instructor getInstructorByDocumento(String documento) {
        return instructorRepository.findByDocumento(documento).orElse(null);
    }

    public InstructorDto transformDto(Instructor instructor) {
        InstructorDto dto = new InstructorDto();
        dto.setApellido(instructor.getApellido());
        dto.setCentro(instructor.getCentro().getUuid());
        dto.setDocumento(instructor.getDocumento());
        dto.setDocumentoType(instructor.getType().toString());
        dto.setEmail(instructor.getEmail());
        dto.setEnabled(instructor.isEnabled());
        dto.setNombre(instructor.getNombre());
        dto.setTelefono(instructor.getTelefono());
        return dto;
    }

    public List<InstructorDto> transformListDto(List<Instructor> instructores) {
        return instructores.stream().map(this::transformDto).toList();
    }

    public Page<Instructor> getPageInstructores(Pageable pageable) {
        return instructorRepository.findAll(pageable);
    }

    public PageDto<InstructorDto> getPageDtoInstructores(int page, int size) {
        Page<Instructor> instructores = getPageInstructores(PageRequest.of(page, size));
        PageDto<InstructorDto> pageDto = new PageDto<>(instructores);
        pageDto.setContent(this.transformListDto(instructores.getContent()));
        return pageDto;
    }

}