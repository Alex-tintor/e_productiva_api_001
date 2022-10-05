package com.sena.eproductiva.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dao.entitys.FormatoEntity;
import com.sena.eproductiva.manager.services.FormatoService;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/api/seguimiento")
public class FormatoController {
    @Autowired
    FormatoService formatoService;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<?> getAllFormatos() {
        List<FormatoEntity> response = formatoService.getAllFormato();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}") // api/formato/api/formato/id
    public @ResponseBody ResponseEntity<?> getFormatoById(@PathVariable("id") long id) {
        Optional<FormatoEntity> response = formatoService.getFormatoById(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public @ResponseBody ResponseEntity<?> updateFichas(@RequestBody FormatoEntity formatoEntity) {
        FormatoEntity response = formatoService.createFormato(formatoEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("//{id}")
    public @ResponseBody ResponseEntity<?> createFicha(@RequestBody FormatoEntity formatoEntity,
            @PathVariable("id") long id) {
        FormatoEntity response = formatoService.createFormato(formatoEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("//{id}")
    public @ResponseBody ResponseEntity<?> deleteFichaById(@PathVariable("id") long id) {
        formatoService.deleteFormatoById(id);
        return new ResponseEntity<>("ficha Inhabilitada con exito", HttpStatus.ACCEPTED);
    }

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("ok", HttpStatus.ACCEPTED);
    }

}