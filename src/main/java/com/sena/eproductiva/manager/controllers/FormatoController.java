package com.sena.eproductiva.manager.controllers;

import java.util.Arrays;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dto.ActionDto;
import com.sena.eproductiva.manager.models.dto.FormatoDto;
import com.sena.eproductiva.manager.models.dto.InvalidDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.dto.ResponseDto;
import com.sena.eproductiva.manager.models.entitys.Formato;
import com.sena.eproductiva.manager.models.enums.ResponseType;
import com.sena.eproductiva.manager.services.FormatoService;
import com.sena.eproductiva.manager.services.MessageService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@CrossOrigin("*")
@RequestMapping("/seguimientos")
public class FormatoController {
    
    @Autowired
    private FormatoService formatoService;

    @Autowired
    private MessageService messageService;

    @GetMapping()
    public @ResponseBody ResponseEntity<ResponseDto> getAllFormatos(@RequestHeader("page-number") Integer page,
    @RequestHeader("page-size") Integer size){
    PageDto<FormatoDto> response = formatoService.getPageDtoFormato(page, size);
    return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> getFormatoById(@PathVariable("documento") Long documento){
        Formato formato = formatoService.getFormatoById(documento);
        if(Objects.isNull(formato))
            return new ResponseEntity<>(new ActionDto("El Formato con el documento:" + documento + "no existe"),
                HttpStatus.BAD_REQUEST);
        FormatoDto response = formatoService.transformDto(formato);
        System.out.println(response);
        // TODO return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        return new ResponseEntity<>(new ActionDto("el trabajo del programador si ha servido :D"), HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> createFormato(
            @Valid @ModelAttribute FormatoDto formatoDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (formatoService.validateExist(formatoDto)) {
            String[] error = { "Formato con documentos enviados ya existe" };
            return new ResponseEntity<>(
                    new InvalidDto(ResponseType.ENTITY_EXIST, Arrays.asList(error), request.getRequestURI()),
                    HttpStatus.BAD_REQUEST);
        }
        Formato Formato = formatoService.createFormato(formatoDto);
        // TODO return new ResponseEntity<>(formatoService.transformDto(Formato),HttpStatus.CREATED);
        System.out.println(Formato);
        return new ResponseEntity<>(new ActionDto("todo chido mi rey"), HttpStatus.CREATED);
    }

    @PutMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> updateFormato(@PathVariable("documento") Long documento,
            @Valid @ModelAttribute FormatoDto FormatoDto,BindingResult validationResult,
            HttpServletRequest request){
        if(validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if(Objects.isNull(formatoService.getFormatoById(documento)))
            return new ResponseEntity<>(new ActionDto("Formato con el Documento:"+documento+"no existe"),
                HttpStatus.BAD_REQUEST);
        // TODO Formato Formato = formatoService.updateFormato(FormatoDto, documento);
        // TODO return new ResponseEntity<>(formatoService.transformDto(aprendiz),HttpStatus.ACCEPTED);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}