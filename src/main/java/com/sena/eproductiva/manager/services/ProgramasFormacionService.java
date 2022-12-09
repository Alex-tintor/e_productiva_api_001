package com.sena.eproductiva.manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.dto.ProgramaDto;
import com.sena.eproductiva.manager.models.entitys.Programa;

import com.sena.eproductiva.manager.repositories.ProgramasFormacionRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProgramasFormacionService {
    @Autowired
    private ProgramasFormacionRepository programasFormacionRepository;

    public List<Programa> getAllProgramas() {
        return programasFormacionRepository.findAll();
      }
        
      public Programa getProgramasFormacionByName(String id) {
      return programasFormacionRepository.findByNombre(id).orElse(null);
      }

      public Programa createPrograma(ProgramaDto programaDto) {
      return updatePrograma(programaDto, null);
      }
      
      public Programa updatePrograma(ProgramaDto programaDto, String nombre) {
      Programa programa = this.getProgramasFormacionByName(nombre);
      if(Objects.isNull(programa))
            programa = new Programa();
      programa.setId(programaDto.getId());
      programa.setNombre(programaDto.getNombre());
      programa.setNivel(programaDto.getNivel());
      programa.setEnabled(programaDto.isEnabled());
      return programasFormacionRepository.save(programa);
      } 

      public ProgramaDto transformDto(Programa programa){
            ProgramaDto dto = new ProgramaDto();
            dto.setId(programa.getId());
            dto.setNombre(programa.getNombre());
            dto.setNivel(programa.getNivel());
            dto.setEnabled(programa.isEnabled());
            return dto;
      }

      public List<ProgramaDto> transformListDto(List<Programa> programas){
            return programas.stream().map(this::transformDto).collect(Collectors.toList());
      }
      
      public Page<Programa> getPageProgramas(Pageable pageable){
            return programasFormacionRepository.findAll(pageable);
      }

      
      public PageDto<ProgramaDto> getPageDtoProgramas(int page, int size) {
            Page<Programa> programa = getPageProgramas(PageRequest.of(page, size));
            PageDto<ProgramaDto> pageDto = new PageDto<>();
            pageDto.setContent(this.transformListDto(programa.getContent()));
            return pageDto;
      }

      public boolean validateExist(ProgramaDto programaDto){
            return Objects.nonNull(getProgramasFormacionByName(programaDto.getNombre()))
            || Objects.nonNull(getProgramasFormacionByName(programaDto.getNombre()));
      }

      public void disablePrograma(String documento){
      Programa programa = getProgramasFormacionByName(documento);
            programa.setEnabled(false);
            programasFormacionRepository.save(programa);
      }
}
