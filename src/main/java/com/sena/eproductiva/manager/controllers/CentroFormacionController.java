package com.sena.eproductiva.manager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dao.entitys.CentroFormacionEntity;
import com.sena.eproductiva.manager.services.CentroFormacionService;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController // lo registra como controlador
@RequestMapping("/api/centrodeformacion") // la ruta que controla = localhost:8080/api/v1
public class CentroFormacionController {
    @Autowired
    CentroFormacionService centroFormacionService;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<?> getAllCentroFormacion() {
        List<CentroFormacionEntity> response = centroFormacionService.getAllCentroFormacion(); 
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<?> getCentroFormacionById(@PathVariable("id") long id) {
        Optional<CentroFormacionEntity> response = centroFormacionService.getCentroFormacionById(id);
        return new ResponseEntity<>(response , HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<?> updateCentroFormacion(@RequestBody CentroFormacionEntity centroEntity) {
        CentroFormacionEntity response = centroFormacionService.updateCentro(centroEntity);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/")
    public @ResponseBody ResponseEntity<?> createCentroFormacion(@RequestBody CentroFormacionEntity centroEntity){
        CentroFormacionEntity response = centroFormacionService.createCentro(centroEntity);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<?> dropCentroFormacion(@PathVariable("id") Long id) {
        centroFormacionService.deleteCentro(id);
        return new ResponseEntity<>("centro inhabilitado con exito", HttpStatus.ACCEPTED);
    }

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<?> health() {
        return new ResponseEntity<>("ok", HttpStatus.ACCEPTED);
    }

}