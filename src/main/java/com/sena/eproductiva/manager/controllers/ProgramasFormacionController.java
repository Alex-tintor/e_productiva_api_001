package com.sena.eproductiva.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dao.entitys.ProgramasFormacionEntity;
import com.sena.eproductiva.manager.services.ProgramasFormacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1") 
public class ProgramasFormacionController {
    @Autowired
    ProgramasFormacionService programasFormacionService;

    @GetMapping("/programasFormacion")
    public @ResponseBody ResponseEntity<?> getAllProgramasFormacion(){
        List<ProgramasFormacionEntity> response = programasFormacionService.getAllProgramasFormacion();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/programasFormacion/{id}")
    public @ResponseBody ResponseEntity<?> getProgramasFormacionById(@PathVariable("id") long id) {
        Optional<ProgramasFormacionEntity> response = programasFormacionService.getProgramasFormacionById(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
    
}
