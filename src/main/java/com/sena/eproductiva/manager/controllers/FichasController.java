package com.sena.eproductiva.manager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.entitys.FichaEntity;
import com.sena.eproductiva.manager.services.FichasService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/ficha") // localhost.../api/fichas/id
public class FichasController {

    @Autowired
    private FichasService fichasService;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<?> getAllFichas() {
        List<FichaEntity> response = fichasService.getAllFichas();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<?> getFichasById(@PathVariable("id") long id) {
        Optional<FichaEntity> response = fichasService.getFichaById(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public @ResponseBody ResponseEntity<?> updateFichas(@RequestBody FichaEntity fichasEntity) {
        FichaEntity response = fichasService.createFicha(fichasEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{id}")
    public @ResponseBody ResponseEntity<?> createFicha(@RequestBody FichaEntity fichasEntity,
            @PathVariable("id") long id) {
        FichaEntity response = fichasService.createFicha(fichasEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<?> deleteFichaById(@PathVariable("id") long id) {
        fichasService.deleteFichaById(id);
        return new ResponseEntity<>("ficha Inhabilitada con exito", HttpStatus.ACCEPTED);
    }
}