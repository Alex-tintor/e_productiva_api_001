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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dto.ActionDto;
import com.sena.eproductiva.manager.models.dto.AprendizDto;
import com.sena.eproductiva.manager.models.dto.InvalidDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.dto.ResponseDto;
import com.sena.eproductiva.manager.models.entitys.Aprendiz;
import com.sena.eproductiva.manager.models.enums.ResponseType;
import com.sena.eproductiva.manager.services.AprendicesService;
import com.sena.eproductiva.manager.services.MessageService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin("*")
@RequestMapping("/aprendices")
public class AprendicesController {
    
    @Autowired
    private AprendicesService aprendicesService;

    @Autowired
    private MessageService messageService;

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDto> getAprendices(@RequestHeader("page-number") Integer page,
            @RequestHeader("page-size") Integer size){ 
        PageDto<AprendizDto> response = aprendicesService.getPageDtoAprendices(page, size);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> getAprendicesByDocument(@PathVariable("documento") String documento){
        Aprendiz aprendiz = aprendicesService.getAprendicesByDocument(documento);
        if(Objects.isNull(aprendiz))
            return new ResponseEntity<>(new ActionDto("El aprendiz con el documento:" + documento + "no existe"),
                HttpStatus.BAD_REQUEST);
        AprendizDto response = aprendicesService.transformDto(aprendiz);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> createAprendiz(
            @Valid @ModelAttribute AprendizDto aprendizDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (aprendicesService.validateExist(aprendizDto)) {
            String[] error = { "Aprendic con documentos enviados ya existe" };
            return new ResponseEntity<>(
                    new InvalidDto(ResponseType.ENTITY_EXIST, Arrays.asList(error), request.getRequestURI()),
                    HttpStatus.BAD_REQUEST);
        }
        Aprendiz aprendiz = aprendicesService.createAprendiz(aprendizDto);
        return new ResponseEntity<>(aprendicesService.transformDto(aprendiz),HttpStatus.CREATED);
    }

    @PutMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> updateAprendiz(@PathVariable("documento") String documento,
            @Valid @ModelAttribute AprendizDto aprendizDto,BindingResult validationResult,
            HttpServletRequest request){
        if(validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if(Objects.isNull(aprendicesService.getAprendicesByDocument(documento)))
            return new ResponseEntity<>(new ActionDto("Aprendiz con el Documento:"+documento+"no existe"),
                HttpStatus.BAD_REQUEST);
        Aprendiz aprendiz = aprendicesService.updateAprendiz(aprendizDto, documento);
        AprendizDto response = aprendicesService.transformDto(aprendiz);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> deleteAprendixById(@PathVariable("documento") String documento){
        if(Objects.isNull(aprendicesService.getAprendicesByDocument(documento)))
            return new ResponseEntity<>(new ActionDto("Instructor con documento: "+documento+" no existe"),
                HttpStatus.BAD_REQUEST);
        aprendicesService.disabreAprendiz(documento);
        return new ResponseEntity<>(new ActionDto("El Programador se merece un tinto con un mustang"),HttpStatus.ACCEPTED);
    }

    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health(){
        return new ResponseEntity<>("Ok",HttpStatus.OK);
    }
}