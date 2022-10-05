package com.sena.eproductiva.manager.controllers;

import java.util.List;
import java.util.Optional;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dao.entitys.AprendicesEntity;
import com.sena.eproductiva.manager.models.dao.entitys.CentroFormacionEntity;
import com.sena.eproductiva.manager.services.AprendicesService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/api/aprendices")
public class AprendicesController {
    @Autowired
    AprendicesService aprendicesService;

    @GetMapping("/")
    public @ResponseBody ResponseEntity<?> getAllAprendices() {
        List<AprendicesEntity> response = aprendicesService.getAllPrendices();
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<?> getAprendicesById(@PathVariable("id") long id) {
        Optional<AprendicesEntity> response = aprendicesService.getAprendicesById(id);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public @ResponseBody ResponseEntity<?> updateAprendices(@RequestBody AprendicesEntity aprendicesEntity){
        AprendicesEntity response = aprendicesService.updateAprendiz(aprendicesEntity);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    public @ResponseBody ResponseEntity<?> createAprendiz(@RequestBody AprendicesEntity aprendicesEntity){
        AprendicesEntity response = aprendicesService.createAprendiz(aprendicesEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<?> dropAprendiz(@PathVariable("id") long id){
        aprendicesService.deleteAprendiz(id);
        return new ResponseEntity<>("centro inhabilitado con exito",HttpStatus.ACCEPTED);
    }
}
