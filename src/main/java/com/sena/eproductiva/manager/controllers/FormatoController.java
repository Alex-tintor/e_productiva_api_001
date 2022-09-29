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

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/api/formato")
public class FormatoController {
    @Autowired
    FormatoService formatoService;
    
    @GetMapping("/seguimiento")
    public @ResponseBody ResponseEntity<?> getAllFormatos() {
        List<FormatoEntity> response = formatoService.getAllFormato();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/api/formato/{id}")
    public @ResponseBody ResponseEntity<?> getFormatoById(@PathVariable("id") long id){ 
        Optional<FormatoEntity> response = formatoService.getFormatoById(id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    
}
