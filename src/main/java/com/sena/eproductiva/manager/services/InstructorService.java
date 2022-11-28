package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.InstructorDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.entitys.Instructor;
import com.sena.eproductiva.manager.models.enums.DocumentoType;
import com.sena.eproductiva.manager.repositories.InstructorRepository;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CentroFormacionService centroFormacionService;

    /**
     * 
     * @return
     */
    public List<Instructor> getInstructores() {
        return instructorRepository.findAll();
    }

    /**
     * 
     * @param uuid
     * @return
     */
    public Instructor getInstructorByUUID(String uuid) {
        return instructorRepository.findById(uuid).orElse(null);
    }

    /**
     * 
     * @param documento
     * @return
     */
    public Instructor getInstructorByDocumento(String documento) {
        return instructorRepository.findByDocumento(documento).orElse(null);
    }

    /**
     * 
     * @param instructorDto
     * @return
     */
    public Instructor createInstructor(InstructorDto instructorDto) {
        return updateInstructor(instructorDto, null);
    }

    /**
     * 
     * @param instructorDto
     * @param documento
     * @return
     */
    public Instructor updateInstructor(InstructorDto instructorDto, String documento) {
        Instructor instructor = this.getInstructorByDocumento(documento);
        if (Objects.isNull(instructor))
            instructor = new Instructor();
        instructor.setApellido(instructorDto.getApellido());
        instructor.setNombre(instructorDto.getNombre());
        System.out.println(instructorDto.getCentro() + "valor antes");
        instructor.setCentro(centroFormacionService.getCentroFormacionById(instructorDto.getCentro()));
        System.out.println(instructor.getCentro() + "valor despues");
        instructor.setDocumento(instructorDto.getDocumento());
        instructor.setEmail(instructorDto.getEmail());
        instructor.setEnabled(true);
        instructor.setTelefono(instructorDto.getTelefono());
        instructor.setType(DocumentoType.valueOf(instructorDto.getDocumentoType()));
        return instructorRepository.save(instructor);
    }

    /**
     * 
     * @param instructor
     * @return
     */
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

    /**
     * 
     * @param instructores
     * @return
     */
    public List<InstructorDto> transformListDto(List<Instructor> instructores) {
        return instructores.stream().map(this::transformDto).collect(Collectors.toList());
    }

    /**
     * 
     * @param pageable
     * @return
     */
    public Page<Instructor> getPageInstructores(Pageable pageable) {
        return instructorRepository.findAll(pageable);
    }

    /**
     * 
     * @param page
     * @param size
     * @return
     */
    public PageDto<InstructorDto> getPageDtoInstructores(int page, int size) {
        Page<Instructor> instructores = getPageInstructores(PageRequest.of(page, size));
        PageDto<InstructorDto> pageDto = new PageDto<>();
        pageDto.setContent(this.transformListDto(instructores.getContent()));
        return pageDto;
    }

    /**
     * 
     * @param instructor
     * @return
     */
    public boolean validarExistencia(InstructorDto instructor) {
        return Objects.nonNull(getInstructorByDocumento(instructor.getTelefono()))
                || Objects.nonNull(getInstructorByDocumento(instructor.getDocumento()))
                || Objects.nonNull(getInstructorByDocumento(instructor.getEmail()));
    }

    /**
     * 
     * @param documento
     */
    public void disableInstructor(String documento) {
        Instructor instructor = getInstructorByDocumento(documento);
        instructor.setEnabled(false);
        instructorRepository.save(instructor);
    }

}