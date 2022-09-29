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
import org.springframework.web.bind.annotation.PostMapping;

@RestController // lo registra como controlador
@RequestMapping("/api/centros") // la ruta que controla = localhost:8080/api/v1
public class CentroFormacionController {
    @Autowired
    CentroFormacionService centroFormacionService;

    @GetMapping("/centrodeformacion")
    public @ResponseBody ResponseEntity<?> getAllCentroFormacion() {
        List<CentroFormacionEntity> response = centroFormacionService.getAllCentroFormacion(); 
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/centrodeformacion/{id}")
    public @ResponseBody ResponseEntity<?> getCentroFormacionById(@PathVariable("id") long id) {
        Optional<CentroFormacionEntity> response = centroFormacionService.getCentroFormacionById(id);
        return new ResponseEntity<>(response , HttpStatus.ACCEPTED);
    }

    @PutMapping("/centrodeformacion/{id}")
    public @ResponseBody ResponseEntity<String> updateCentroFormacion(@PathVariable("id") String id) {
        return new ResponseEntity<>("se ha actualizado el centro de formacion", HttpStatus.OK);
    }

    @PostMapping("/centrodeformacion")
    public @ResponseBody ResponseEntity<String> createCentroFormacion() {
        return new ResponseEntity<>("se ha creado el centro de formacion", HttpStatus.CREATED);
    }

    @DeleteMapping("/centrodeformacion/{id}")
    public @ResponseBody ResponseEntity<String> dropCentroFormacion(@PathVariable("id") String id) {
        return new ResponseEntity<>("se borro exitosamente el centro de formacion", HttpStatus.ACCEPTED);
    }

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("ok", HttpStatus.ACCEPTED);
    }

}