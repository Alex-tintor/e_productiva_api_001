package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.FormatoDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.entitys.Formato;
import com.sena.eproductiva.manager.repositories.FormatoRepository;

@Service
public class FormatoService {

    @Autowired
    private FormatoRepository formatoRepository;

    @Autowired
    private InstructorService instructorService;

    /**
     * 
     * @return
     */
    public List<Formato> getAllFormato() {
        return formatoRepository.findAll();
    }

    /**
     * 
     * @param id
     * @return
     */
    public Formato getFormatoById(String id) {
        return formatoRepository.findByInstructorDocument(id).orElse(null);
    }

    /**
     * 
     * @param formatoDto
     * @param id
     * @return
     */
    public Formato updateFormato(FormatoDto formatoDto, String id) {
        Formato formato = this.getFormatoById(id);
        if (Objects.isNull(formato))
            formato = new Formato();
        formato.setId(formatoDto.getId());
        formato.setFecha(formatoDto.getFecha());
        formato.setInstructor(instructorService.getInstructorByDocumento(formatoDto.getInstructor()));
        return formatoRepository.save(formato);
    }

    /**
     * 
     * @param formatoDto
     * @return
     */
    public Formato createFormato(FormatoDto formatoDto) {
        return updateFormato(formatoDto, null);
    }

    /**
     * 
     * @param formato
     * @return
     */
    public FormatoDto transformDto(Formato formato) {
        FormatoDto dto = new FormatoDto();
        dto.setId(formato.getId());
        dto.setFecha(formato.getFecha());
        dto.setInstructor(formato.getInstructor().getDocumento());
        return dto;
    }

    /**
     * 
     * @param formatos
     * @return
     */
    public List<FormatoDto> transformListDtos(List<Formato> formatos) {
        return formatos.stream().map(this::transformDto).collect(Collectors.toList());
    }

    /**
     * 
     * @param pageable
     * @return
     */
    public Page<Formato> getPageFormato(Pageable pageable) {
        return formatoRepository.findAll(pageable);
    }

    /**
     * 
     * @param page
     * @param size
     * @return
     */
    public PageDto<FormatoDto> getPageDtoFormato(int page, int size) {
        Page<Formato> formato = getPageFormato(PageRequest.of(page, size));
        PageDto<FormatoDto> pageDto = new PageDto<>();
        pageDto.setContent(this.transformListDtos(formato.getContent()));
        return pageDto;
    }

    /**
     * 
     * @param formatoDto
     * @return
     */
    public boolean validateExist(FormatoDto formatoDto) {
        return Objects.isNull(formatoDto.getId());
    }

}
