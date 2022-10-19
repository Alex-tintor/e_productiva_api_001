package com.sena.eproductiva.manager.controllers;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dto.ActionDto;
import com.sena.eproductiva.manager.models.dto.InstructorDto;
import com.sena.eproductiva.manager.models.dto.InvalidDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.dto.ResponseDto;
import com.sena.eproductiva.manager.models.entitys.Instructor;
import com.sena.eproductiva.manager.models.enums.ResponseType;
import com.sena.eproductiva.manager.services.InstructorService;
import com.sena.eproductiva.manager.services.MessageService;

@RestController
@RequestMapping("/instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private MessageService messageService;

    @GetMapping()
    public @ResponseBody ResponseEntity<ResponseDto> getInstructores(
            @RequestHeader("page-number") Integer page,
            @RequestHeader("page-size") Integer size) {
        PageDto<InstructorDto> response = instructorService.getPageDtoInstructores(page, size);
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

    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> createInstrutor(
            @Valid @ModelAttribute InstructorDto instructorDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (instructorService.validarExistencia(instructorDto)) {
            String[] error = { "Entidad con documentos enviados ya existe" };
            return new ResponseEntity<>(
                    new InvalidDto(ResponseType.ENTITY_EXIST, Arrays.asList(error), request.getRequestURI()),
                    HttpStatus.BAD_REQUEST);
        }
        Instructor instructor = instructorService.createInstructor(instructorDto);
        return new ResponseEntity<>(instructorService.transformDto(instructor), HttpStatus.CREATED);
    }

    @PutMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> updateInstructor(@PathVariable("documento") String documento,
            @Valid @ModelAttribute InstructorDto instructorDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (Objects.isNull(instructorService.getInstructorByDocumento(documento)))
            return new ResponseEntity<>(new ActionDto("Instructor con el documento: " + documento + " no existe"),
                    HttpStatus.BAD_REQUEST);
        Instructor instructor = instructorService.updateInstructor(instructorDto, documento);
        return new ResponseEntity<>(instructorService.transformDto(instructor), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> deleteFichaById(@PathVariable("documento") String documento) {
        if (Objects.isNull(instructorService.getInstructorByDocumento(documento)))
            return new ResponseEntity<>(new ActionDto("Instructor con el documento: " + documento + " no existe"),
                    HttpStatus.BAD_REQUEST);
        instructorService.disableInstructor(documento);
        return new ResponseEntity<>(new ActionDto("Instructor Inabilitado con exito"), HttpStatus.ACCEPTED);
    }

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}