package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.dto.AprendizDto;
import com.sena.eproductiva.manager.models.entitys.Aprendiz;
import com.sena.eproductiva.manager.models.enums.DocumentoType;
import com.sena.eproductiva.manager.models.enums.EtapaType;
import com.sena.eproductiva.manager.repositories.AprendicesRepository;
import com.sena.eproductiva.manager.repositories.FichasRepository;

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
      return aprendicesRepository.fincByDocumento(documento).orElse(null);
      }

      public Aprendiz createAprendiz(AprendizDto aprendizDto) {
      return updateAprendiz(aprendizDto, null);
      }
      
      public Aprendiz updateAprendiz(AprendizDto aprendizDto, String documento) {
       Aprendiz aprendiz = this.getAprendicesByDocument(documento);
       if(Objects.isNull(aprendiz))
            aprendiz = new Aprendiz();
            aprendiz.setDocumento(aprendizDto.getCc());
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
      
      public void deleteAprendiz(long id) {
      aprendicesRepository.deleteById(id);
      }
      
      
      public List<AprendizDto> getAllAprendizDtos() {
      return this.getAllAprendices().stream().map(aprendiz -> {
      AprendizDto dto = new AprendizDto();
      dto.setCc(aprendiz.getCedula());
      dto.setNombre(aprendiz.getNombre());
      dto.setApellido(aprendiz.getApellido());
      dto.setEmail(aprendiz.getEmail());
      dto.setTelefono(aprendiz.getTelefono());
      dto.setFichaId(aprendiz.getFichaEntity().getId());
      dto.setEtapa(aprendiz.getEtapa());
      dto.setEnabled(aprendiz.isEnabled());
      return dto;
      }).collect(Collectors.toList());
      }
      
      public List<AprendizDto> getAprendizDtoById(long id) {
      return this.getAprendicesById(id).stream().map(aprendiz -> {
      AprendizDto dto = new AprendizDto();
      dto.setCc(id);
      dto.setNombre(aprendiz.getNombre());
      dto.setApellido(aprendiz.getApellido());
      dto.setEmail(aprendiz.getEmail());
      dto.setTelefono(aprendiz.getTelefono());
      dto.setFichaId(aprendiz.getFichaEntity().getId());
      dto.setEtapa(aprendiz.getEtapa());
      dto.setEnabled(aprendiz.isEnabled());
      return dto;
      }).collect(Collectors.toList());
      }
     
}