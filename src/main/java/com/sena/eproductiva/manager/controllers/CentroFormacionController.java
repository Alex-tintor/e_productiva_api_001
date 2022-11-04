package com.sena.eproductiva.manager.controllers;

import java.util.Arrays;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dto.ActionDto;
import com.sena.eproductiva.manager.models.dto.CentroFormacionDto;
import com.sena.eproductiva.manager.models.dto.InvalidDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.dto.ResponseDto;
import com.sena.eproductiva.manager.models.entitys.Centro;
import com.sena.eproductiva.manager.models.enums.ResponseType;
import com.sena.eproductiva.manager.services.CentroFormacionService;
import com.sena.eproductiva.manager.services.MessageService;

@RestController
@CrossOrigin("*")
@RequestMapping("/centros")
public class CentroFormacionController {
    
    @Autowired
    CentroFormacionService centroFormacionService;

    @Autowired
    MessageService messageService;

    @GetMapping()
    public @ResponseBody ResponseEntity<ResponseDto> getCentros(@RequestHeader("page-number") Integer page ,@RequestHeader("page-size") Integer size){
        PageDto<CentroFormacionDto> response = centroFormacionService.getPageDtoCentro(page,size);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseDto> getCentroById(@PathVariable("id") String id){
        Centro centro = centroFormacionService.getCentroFormacionById(id);
        if(Objects.isNull(centro))
            return new ResponseEntity<>(new ActionDto("El centro con nombre/id:"+id+"no existe"),
                HttpStatus.BAD_REQUEST);
        CentroFormacionDto response = centroFormacionService.transformDto(centro);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        
    }

    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> createCentro(
            @Valid @ModelAttribute CentroFormacionDto centroFormacionDto, BindingResult validationResult,
            HttpServletRequest request){
        if(validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if(centroFormacionService.validateExist(centroFormacionDto)){
            String[] error = {"El centro ya existe"};
            return new ResponseEntity<>(
                new InvalidDto(ResponseType.ENTITY_EXIST, Arrays.asList(error), request.getRequestURI()),
                HttpStatus.BAD_REQUEST);
        }
        Centro centro = centroFormacionService.createCentro(centroFormacionDto);
        return new ResponseEntity<>(centroFormacionService.transformDto(centro), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseDto> updateCentro(
            @PathVariable("id") String id,@Valid @RequestBody CentroFormacionDto centroFormacionDto,
            BindingResult validationResult, HttpServletRequest request){
        if(validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if(Objects.isNull(centroFormacionService.getCentroFormacionById(id))){
            return new ResponseEntity<>(new ActionDto("el Centro:"+id+"no existe"),HttpStatus.BAD_REQUEST);
        }
        Centro centro = centroFormacionService.updateCentro(centroFormacionDto,id);
        CentroFormacionDto response = centroFormacionService.transformDto(centro);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseDto> unabledCentro(@PathVariable("id") String id){
        if(Objects.isNull(centroFormacionService.getCentroFormacionById(id)))
            return new ResponseEntity<>(new ActionDto("el Centro: "+id+" no existe"),HttpStatus.BAD_REQUEST);
        centroFormacionService.disableCentro(id);
        return new ResponseEntity<>(new ActionDto("viernes 21 de octubre y son las 11:22 de la noche :D"),HttpStatus.ACCEPTED);
    }

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}