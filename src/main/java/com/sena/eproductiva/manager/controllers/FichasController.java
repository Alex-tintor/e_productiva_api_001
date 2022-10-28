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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dto.ActionDto;
import com.sena.eproductiva.manager.models.dto.FichaDto;
import com.sena.eproductiva.manager.models.dto.InvalidDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.dto.ResponseDto;
import com.sena.eproductiva.manager.models.entitys.Ficha;
import com.sena.eproductiva.manager.models.enums.ResponseType;
import com.sena.eproductiva.manager.services.FichasService;
import com.sena.eproductiva.manager.services.MessageService;

@RestController
@CrossOrigin("*")
@RequestMapping("/fichas")
public class FichasController {

    @Autowired
    FichasService fichasService;

    @Autowired
    MessageService messageService;

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDto> getFichas(@RequestHeader("page-number") Integer page, @RequestHeader("page-size") Integer size){
        PageDto<FichaDto> response = fichasService.getFichasDtoPage(page,size);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseDto> getFichaById(@PathVariable("id") String id){
        Ficha ficha = fichasService.getFichaById(id);
        if(Objects.isNull(ficha))
            return new ResponseEntity<>(new ActionDto("el centro de formacion:"+id+"no existe"),HttpStatus.BAD_REQUEST);
        // TODO FichaDto response = fichasService.transfomrDto(ficha);
        // TODO return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> createFicha(
            @Valid @ModelAttribute FichaDto FichaDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (fichasService.validateExist(FichaDto)) {
            String[] error = { "Entidad con documentos enviados ya existe" };
            return new ResponseEntity<>(
                    new InvalidDto(ResponseType.ENTITY_EXIST, Arrays.asList(error), request.getRequestURI()),
                    HttpStatus.BAD_REQUEST);
        }
        // TODO Ficha ficha = fichasService.createFicha(FichaDto);
        // TODO return new ResponseEntity<>(fichasService.transfomrDto(ficha), HttpStatus.CREATED);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseDto> updateCentro(@Valid @PathVariable("id") String id, @ModelAttribute FichaDto fichaDto, BindingResult validationResult,
            HttpServletRequest request){
        if(validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if(Objects.isNull(fichasService.getFichaById(id))){
            return new ResponseEntity<>(new ActionDto("el Centro:"+id+"no existe"),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseDto> unabledCentro(@PathVariable("id") String id){
        if(Objects.isNull(fichasService.getFichaById(id)))
            return new ResponseEntity<>(new ActionDto("el Centro:"+id+"no existe"),HttpStatus.BAD_REQUEST);
        fichasService.disabledFicha(id);
        return new ResponseEntity<>(new ActionDto("viernes 21 de octubre y son las 11:22 de la noche :D"),HttpStatus.ACCEPTED);
    }

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}