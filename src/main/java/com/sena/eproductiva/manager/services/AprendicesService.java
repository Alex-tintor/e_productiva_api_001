package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.AprendizDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.entitys.Aprendiz;
import com.sena.eproductiva.manager.models.enums.DocumentoType;
import com.sena.eproductiva.manager.models.enums.EtapaType;
import com.sena.eproductiva.manager.repositories.AprendicesRepository;

@Service
public class AprendicesService {

    
      @Autowired
      private AprendicesRepository aprendicesRepository;

      @Autowired
      private FichasService fichasService;
      
      public List<Aprendiz> getAllAprendices() {
      return aprendicesRepository.findAll();
      }
      
      public Aprendiz getAprendicesByDocument(String documento) {
      return aprendicesRepository.findByDocumento(documento).orElse(null);
      }

      public Aprendiz createAprendiz(AprendizDto aprendizDto) {
      return updateAprendiz(aprendizDto, null);
      }
      
      public Aprendiz updateAprendiz(AprendizDto aprendizDto, String documento) {
       Aprendiz aprendiz = this.getAprendicesByDocument(documento);
       if(Objects.isNull(aprendiz))
            aprendiz = new Aprendiz();
      aprendiz.setDocumento(aprendizDto.getDocumento());
      aprendiz.setType(DocumentoType.valueOf(aprendizDto.getDocumentoType()));
      aprendiz.setNombre(aprendizDto.getNombre());
      aprendiz.setApellido(aprendizDto.getApellido());
      aprendiz.setEmail(aprendizDto.getEmail());
      aprendiz.setTelefono(aprendizDto.getTelefono());
      aprendiz.setFicha(fichasService.getFichaById(aprendizDto.getFichaId()));
      aprendiz.setEtapa(EtapaType.valueOf(aprendizDto.getEtapa()));
      aprendiz.setEnabled(aprendizDto.isEnabled());
      return aprendicesRepository.save(aprendiz);
      } 

      public AprendizDto transformDto(Aprendiz aprendiz){
            AprendizDto dto = new AprendizDto();
            dto.setDocumento(aprendiz.getDocumento());
            dto.setDocumentoType(aprendiz.getType().toString());
            dto.setNombre(aprendiz.getNombre());
            dto.setApellido(aprendiz.getApellido());
            dto.setEmail(aprendiz.getEmail());
            dto.setTelefono(aprendiz.getTelefono());
            dto.setFichaId(aprendiz.getFicha().getId());
            dto.setEtapa(aprendiz.getEtapa().toString());
            dto.setEnabled(aprendiz.isEnabled());
            return dto;
      }

      public List<AprendizDto> transformListDto(List<Aprendiz> aprendices){
            return aprendices.stream().map(this::transformDto).toList();
      }
      
      public Page<Aprendiz> getPageAprendices(Pageable pageable){
            return aprendicesRepository.findAll(pageable);
      }

     
      public PageDto<AprendizDto> getPageDtoAprendices(int page, int size) {
            Page<Aprendiz> aprendices = getPageAprendices(PageRequest.of(page, size));
            PageDto<AprendizDto> pageDto = new PageDto<>();
            pageDto.setContent(this.transformListDto(aprendices.getContent()));
            return pageDto;
      }

      public boolean validateExist(AprendizDto aprendizDto){
            return Objects.nonNull(getAprendicesByDocument(aprendizDto.getDocumento()))
            || Objects.nonNull(getAprendicesByDocument(aprendizDto.getTelefono()))
            || Objects.nonNull(getAprendicesByDocument(aprendizDto.getEmail()));
      }

      public void disabreAprendiz(String documento){
            Aprendiz aprendiz = getAprendicesByDocument(documento);
            aprendiz.setEnabled(false);
            aprendicesRepository.save(aprendiz);
      }
}