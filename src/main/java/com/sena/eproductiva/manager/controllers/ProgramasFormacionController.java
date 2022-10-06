package com.sena.eproductiva.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dao.entitys.ProgramaFormacionEntity;
import com.sena.eproductiva.manager.services.ProgramasFormacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/programasFormacion")
public class ProgramasFormacionController {
    @Autowired
    ProgramasFormacionService programasFormacionService;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<?> getAllProgramasFormacion() {
        List<ProgramaFormacionEntity> response = programasFormacionService.getAllProgramasFormacion();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<?> getProgramasFormacionById(@PathVariable("id") long id) {
        Optional<ProgramaFormacionEntity> response = programasFormacionService.getProgramasFormacionById(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public @ResponseBody ResponseEntity<?> updateFichas(@RequestBody ProgramaFormacionEntity programasFormacionEntity) {
        ProgramaFormacionEntity response = programasFormacionService.createFicha(programasFormacionEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{id}")
    public @ResponseBody ResponseEntity<?> createFicha(@RequestBody ProgramaFormacionEntity programasFormacionEntity,
            @PathVariable("id") long id) {
        ProgramaFormacionEntity response = programasFormacionService.createFicha(programasFormacionEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<?> deleteFichaById(@PathVariable("id") long id) {
        programasFormacionService.deleteFichaById(id);
        return new ResponseEntity<>("ficha Inhabilitada con exito", HttpStatus.ACCEPTED);
    }

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("ok", HttpStatus.ACCEPTED);
    }

}
