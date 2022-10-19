package com.sena.eproductiva.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.eproductiva.manager.models.entitys.Aprendiz;
import com.sena.eproductiva.manager.repositories.AprendicesRepository;

@Service
public class AprendicesService {

    /*
     * @Autowired
     * private AprendicesRepository aprendicesRepository;
     * 
     * public List<Aprendiz> getAllAprendices() {
     * return aprendicesRepository.findAll();
     * }
     * 
     * public Optional<Aprendiz> getAprendicesById(long id) {
     * return aprendicesRepository.findById(id);
     * }
     * 
     * public Aprendiz updateAprendiz(Aprendiz aprendicesEntity) {
     * return aprendicesRepository.save(aprendicesEntity);
     * }
     * 
     * public Aprendiz createAprendiz(Aprendiz aprendicesEntity) {
     * return aprendicesRepository.save(aprendicesEntity);
     * }
     * 
     * public void deleteAprendiz(long id) {
     * aprendicesRepository.deleteById(id);
     * }
     * 
     * 
     * public List<AprendizDto> getAllAprendizDtos() {
     * return this.getAllAprendices().stream().map(aprendiz -> {
     * AprendizDto dto = new AprendizDto();
     * dto.setCc(aprendiz.getCedula());
     * dto.setNombre(aprendiz.getNombre());
     * dto.setApellido(aprendiz.getApellido());
     * dto.setEmail(aprendiz.getEmail());
     * dto.setTelefono(aprendiz.getTelefono());
     * dto.setFichaId(aprendiz.getFichaEntity().getId());
     * dto.setEtapa(aprendiz.getEtapa());
     * dto.setEnabled(aprendiz.isEnabled());
     * return dto;
     * }).collect(Collectors.toList());
     * }
     * 
     * public List<AprendizDto> getAprendizDtoById(long id) {
     * return this.getAprendicesById(id).stream().map(aprendiz -> {
     * AprendizDto dto = new AprendizDto();
     * dto.setCc(id);
     * dto.setNombre(aprendiz.getNombre());
     * dto.setApellido(aprendiz.getApellido());
     * dto.setEmail(aprendiz.getEmail());
     * dto.setTelefono(aprendiz.getTelefono());
     * dto.setFichaId(aprendiz.getFichaEntity().getId());
     * dto.setEtapa(aprendiz.getEtapa());
     * dto.setEnabled(aprendiz.isEnabled());
     * return dto;
     * }).collect(Collectors.toList());
     * }
     */
}