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

    /**
     * Metodo para obtener todos los Formatos
     * 
     * @param page resive el numero de paginas
     * @param size resive el tamaño de la pagina
     * @return retorna los Formatos y el estado de la peticion
     */
    @GetMapping()
    public @ResponseBody ResponseEntity<ResponseDto> getAllFormatos(@RequestHeader("page-number") Integer page,
            @RequestHeader("page-size") Integer size) {
        PageDto<FormatoDto> response = formatoService.getPageDtoFormato(page, size);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Metodo para obtener un Formato por medio de un id
     * 
     * @param documento resive el documeto del Formato a consultar
     * @return retorna el Formato y el estado de la peticion
     */
    @GetMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> getFormatoById(@PathVariable("documento") String documento) {
        Formato formato = formatoService.getFormatoById(documento);
        if (Objects.isNull(formato))
            return new ResponseEntity<>(new ActionDto("El Formato con el documento:" + documento + "no existe"),
                    HttpStatus.BAD_REQUEST);
        FormatoDto response = formatoService.transformDto(formato);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Metodo para crear un Formato
     * 
     * @param formatoDto       resive el dto de Formato
     * @param validationResult resive errores de registro
     * @param request          resive el estado de la peticion
     * @return retorna el nuevo Formato y el estatus de Created
     */
    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> createFormato(
            @Valid @ModelAttribute FormatoDto formatoDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (formatoService.validateExist(formatoDto)) {
            String[] error = { "El Formato ya existe" };
            return new ResponseEntity<>(
                    new InvalidDto(ResponseType.ENTITY_EXIST, Arrays.asList(error), request.getRequestURI()),
                    HttpStatus.BAD_REQUEST);
        }
        Formato formato = formatoService.createFormato(formatoDto);
        return new ResponseEntity<>(formatoService.transformDto(formato), HttpStatus.CREATED);
    }

    /**
     * Metodo para actualizar un Formato por medio de un identificador
     * 
     * @param documento        resive el identificador del Formato a modificar
     * @param formatoDto       resive el dto de Formato
     * @param validationResult resive errores de registro
     * @param request          resive el estado de la peticion
     * @return retorna el Formato actualizado y el estado de la peticion
     */
    @PutMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> updateFormato(@PathVariable("documento") String documento,
            @Valid @ModelAttribute FormatoDto formatoDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (Objects.isNull(formatoService.getFormatoById(documento)))
            return new ResponseEntity<>(new ActionDto("Formato con el Documento: " + documento + " no existe"),
                    HttpStatus.BAD_REQUEST);
        Formato formato = formatoService.updateFormato(formatoDto, documento);
        return new ResponseEntity<>(formatoService.transformDto(formato), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo para verificar el funcionamiento del controlador
     * 
     * @return retorna el estado de la peticion
     */
    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}