package com.sena.eproductiva.manager.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dto.ActionDto;
import com.sena.eproductiva.manager.models.dto.InstructorDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.dto.ResponseDto;
import com.sena.eproductiva.manager.models.entitys.Instructor;
import com.sena.eproductiva.manager.services.InstructorService;

@RestController
@RequestMapping("/instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping()
    public @ResponseBody ResponseEntity<ResponseDto> getInstructores() {
        PageDto<InstructorDto> response = instructorService.getPageDtoInstructores(0, 3);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> getFormatoById(@PathVariable("documento") String documento) {
        Instructor instructor = instructorService.getInstructorByDocumento(documento);
        if (Objects.isNull(instructor))
            return new ResponseEntity<>(new ActionDto("Instructor con el documento: " + documento + " no existe"),
                    HttpStatus.BAD_REQUEST);
        InstructorDto response = instructorService.transformDto(instructor);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /*
     * @PutMapping("/")
     * public @ResponseBody ResponseEntity<?> updateFichas(@RequestBody
     * InstructorEntity instructorEntity) {
     * InstructorEntity response =
     * instructorService.createInstructor(instructorEntity);
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @PostMapping("/{id}")
     * public @ResponseBody ResponseEntity<?> createFicha(@RequestBody
     * InstructorEntity instructorEntity,
     * 
     * @PathVariable("id") long id) {
     * InstructorEntity response =
     * instructorService.updateInstructor(instructorEntity);
     * return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
     * }
     * 
     * @DeleteMapping("/{id}")
     * public @ResponseBody ResponseEntity<?> deleteFichaById(@PathVariable("id")
     * long id) {
     * instructorService.deleteInstructorById(id);
     * return new ResponseEntity<>("ficha Inhabilitada con exito",
     * HttpStatus.ACCEPTED);
     * }
     */

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}