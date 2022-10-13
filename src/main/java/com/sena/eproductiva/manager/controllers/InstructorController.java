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

import com.sena.eproductiva.manager.models.dto.InstructorDto;
import com.sena.eproductiva.manager.models.entitys.InstructorEntity;
import com.sena.eproductiva.manager.services.InstructorService;

@RestController
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequestMapping("/api/instructor")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @GetMapping()
    public @ResponseBody ResponseEntity<List<InstructorDto>> getAllFormatos() {
        List<InstructorDto> response = instructorService.getAllInstructorDtos();
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}") // api/formato/api/formato/id
    public @ResponseBody ResponseEntity<?> getFormatoById(@PathVariable("id") long id) {
        Optional<InstructorEntity> response = instructorService.getInstructorById(id);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/")
    public @ResponseBody ResponseEntity<?> updateFichas(@RequestBody InstructorEntity instructorEntity) {
        InstructorEntity response = instructorService.createInstructor(instructorEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/{id}")
    public @ResponseBody ResponseEntity<?> createFicha(@RequestBody InstructorEntity instructorEntity,
            @PathVariable("id") long id) {
        InstructorEntity response = instructorService.updateInstructor(instructorEntity);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<?> deleteFichaById(@PathVariable("id") long id) {
        instructorService.deleteInstructorById(id);
        return new ResponseEntity<>("ficha Inhabilitada con exito", HttpStatus.ACCEPTED);
    }

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("ok", HttpStatus.ACCEPTED);
    }
}
