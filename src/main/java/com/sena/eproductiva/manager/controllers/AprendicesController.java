package com.sena.eproductiva.manager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dto.AprendizDto;
import com.sena.eproductiva.manager.models.entitys.AprendizEntity;
import com.sena.eproductiva.manager.services.AprendicesService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/aprendices")
public class AprendicesController {

    @Autowired
    private AprendicesService aprendicesService;

    @GetMapping()
    public @ResponseBody ResponseEntity<List<AprendizDto>> getAllAprendices() {
        List<AprendizDto> response = aprendicesService.getAllAprendizDtos();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<?> getAprendicesById(@PathVariable("id") long id) {
        Optional<AprendizEntity> response = aprendicesService.getAprendicesById(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public @ResponseBody ResponseEntity<?> updateAprendices(@RequestBody AprendizEntity aprendicesEntity) {
        AprendizEntity response = aprendicesService.updateAprendiz(aprendicesEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    public @ResponseBody ResponseEntity<?> createAprendiz(@RequestBody AprendizEntity aprendicesEntity) {
        AprendizEntity response = aprendicesService.createAprendiz(aprendicesEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<?> dropAprendiz(@PathVariable("id") long id) {
        aprendicesService.deleteAprendiz(id);
        return new ResponseEntity<>("centro inhabilitado con exito", HttpStatus.ACCEPTED);
    }
}
