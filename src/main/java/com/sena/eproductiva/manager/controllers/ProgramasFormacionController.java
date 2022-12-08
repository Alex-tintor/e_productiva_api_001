package com.sena.eproductiva.manager.controllers;

import java.util.Arrays;
import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sena.eproductiva.manager.models.dto.ActionDto;
import com.sena.eproductiva.manager.models.dto.InvalidDto;
import com.sena.eproductiva.manager.models.dto.PageDto;
import com.sena.eproductiva.manager.models.dto.ProgramaDto;
import com.sena.eproductiva.manager.models.dto.ResponseDto;
import com.sena.eproductiva.manager.models.entitys.Programa;
import com.sena.eproductiva.manager.models.enums.ResponseType;
import com.sena.eproductiva.manager.services.MessageService;
import com.sena.eproductiva.manager.services.ProgramasFormacionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/programas")
public class ProgramasFormacionController {

    @Autowired
    ProgramasFormacionService programasFormacionService;

    @Autowired
    private MessageService messageService;

    /**
     * Metodo para obtener todos los programas
     * 
     * @param page resive el numero de paginas
     * @param size resive el tamaño de las consultas
     * @return retorna los programas y el status de la peticion
     */
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDto> getProgramas(@RequestHeader("page-number") Integer page,
            @RequestHeader("page-size") Integer size) {
        PageDto<ProgramaDto> response = programasFormacionService.getPageDtoProgramas(page, size);
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Metodo para obtener un Programa por medio de un id
     * 
     * @param nombre resive el nobre del program a consultar
     * @return retorna el Programa y el status de la peticion
     */
    @GetMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> getProgramasByName(@PathVariable("documento") String nombre) {
        Programa programa = programasFormacionService.getProgramasFormacionByName(nombre);
        if (Objects.isNull(programa))
            return new ResponseEntity<>(new ActionDto("Programa: " + nombre + " no existe"),
                    HttpStatus.BAD_REQUEST);
        ProgramaDto response = programasFormacionService.transformDto(programa);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Metodo para crear un nuevo Programa
     * 
     * @param programaDto      resive el dto Programa
     * @param validationResult resive errores de registro
     * @param request          resive el status de la peticion
     * @return retorna el nuevo Programa y el status de la respuesta
     */
    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> createPrograma(
            @Valid @ModelAttribute ProgramaDto programaDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (programasFormacionService.validateExist(programaDto)) {
            String[] error = { "Programa con documentos enviados ya existe" };
            return new ResponseEntity<>(
                    new InvalidDto(ResponseType.ENTITY_EXIST, Arrays.asList(error), request.getRequestURI()),
                    HttpStatus.BAD_REQUEST);
        }
        Programa programa = programasFormacionService.createPrograma(programaDto);
        return new ResponseEntity<>(programasFormacionService.transformDto(programa), HttpStatus.CREATED);

    }

    /**
     * Metodo para actualizar un Programa
     * 
     * @param documento        resive el documento del programa a modificar
     * @param programaDto      resive el dto Programa
     * @param validationResult resive errores de registro
     * @param request          resive el estado de la peticion
     * @return retorna el Programa modificado y el status de la respuesta
     */
    @PutMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> updatePrograma(@PathVariable("documento") String documento,
            @Valid @ModelAttribute ProgramaDto programaDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (Objects.isNull(programasFormacionService.getProgramasFormacionByName(documento)))
            return new ResponseEntity<>(new ActionDto("Programa: " + documento + " no existe"),
                    HttpStatus.BAD_REQUEST);
        Programa programa = programasFormacionService.updatePrograma(programaDto, documento);
        return new ResponseEntity<>(programasFormacionService.transformDto(programa), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo para deshabilitar un Programa
     * 
     * @param documento resive el documento del programa a deshabilitar
     * @return retorna el estado de la respuesta
     */
    @DeleteMapping("/{documento}")
    public @ResponseBody ResponseEntity<ResponseDto> deletePrograma(@PathVariable("documento") String documento) {
        if (Objects.isNull(programasFormacionService.getProgramasFormacionByName(documento)))
            return new ResponseEntity<>(new ActionDto("Programa: " + documento + " no existe"),
                    HttpStatus.BAD_REQUEST);
        programasFormacionService.disablePrograma(documento);
        return new ResponseEntity<>(new ActionDto("El Programador se merece un tinto con un mustang"),
                HttpStatus.ACCEPTED);
    }

    /**
     * Metodo para verificar el funcionamiento del controlador
     * 
     * @return retorna la respuesta del servidor
     */
    @GetMapping("/health")
    public @ResponseBody ResponseEntity<String> health() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

}