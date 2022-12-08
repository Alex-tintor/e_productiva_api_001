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

    /**
     * Metodo para obtener las Fichas
     * 
     * @param page resive el numero de pagina
     * @param size resive el tamño de la pagina
     * @return retorna las Fichas y el estatus de aceptado
     */
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDto> getFichas(@RequestHeader("page-number") Integer page,
            @RequestHeader("page-size") Integer size) {
        PageDto<FichaDto> response = fichasService.getFichasDtoPage(page, size);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Metodo para obtener una Ficha con un id
     * 
     * @param id resive el identificador de la ficha
     * @return retorna la Ficha y el estatus de aceptado, si la ficha no existe
     *         retorna un bad request
     */
    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseDto> getFichaById(@PathVariable("id") String id) {
        Ficha ficha = fichasService.getFichaById(id);
        if (Objects.isNull(ficha))
            return new ResponseEntity<>(new ActionDto("La Ficha de formacion:" + id + "no existe"),
                    HttpStatus.BAD_REQUEST);
        FichaDto response = fichasService.transfomrDto(ficha);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    /**
     * Metodo para crear una Ficha nueva
     * 
     * @param fichaDto         resive el dto de Ficha
     * @param validationResult resive errores de registro
     * @param request          resive el estado de la peticion
     * @return retorna una nueva Ficha y el estado de creado
     */
    @PostMapping()
    public @ResponseBody ResponseEntity<ResponseDto> createFicha(
            @Valid @ModelAttribute FichaDto fichaDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (fichasService.validateExist(fichaDto)) {
            String[] error = { "Entidad con documentos enviados ya existe" };
            return new ResponseEntity<>(
                    new InvalidDto(ResponseType.ENTITY_EXIST, Arrays.asList(error), request.getRequestURI()),
                    HttpStatus.BAD_REQUEST);
        }
        Ficha ficha = fichasService.createFicha(fichaDto);
        return new ResponseEntity<>(fichasService.transfomrDto(ficha), HttpStatus.CREATED);
    }

    /**
     * Metodo para actualizar una ficha
     * 
     * @param id               resive el id de la ficha a modificar
     * @param fichaDto         resive el dto de Ficha
     * @param validationResult resive errores de registro
     * @param request          resive el estado de la peticion
     * @return retorna la Ficha actualizada y el estatus de la peticion
     */
    @PutMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseDto> updateFicha(@Valid @PathVariable("id") String id,
            @ModelAttribute FichaDto fichaDto, BindingResult validationResult,
            HttpServletRequest request) {
        if (validationResult.hasErrors())
            return messageService.invalidFields(validationResult, request.getRequestURI());
        if (Objects.isNull(fichasService.getFichaById(id))) {
            return new ResponseEntity<>(new ActionDto("La Ficha:" + id + "no existe"), HttpStatus.BAD_REQUEST);
        }
        Ficha ficha = fichasService.createFicha(fichaDto);
        return new ResponseEntity<>(fichasService.transfomrDto(ficha), HttpStatus.ACCEPTED);
    }

    /**
     * Metodo para deshabilitar una Ficha
     * 
     * @param id resive el id de la ficha a deshabilitar
     * @return retorna el estatus de la peticion
     */
    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<ResponseDto> unabledFicha(@PathVariable("id") String id) {
        if (Objects.isNull(fichasService.getFichaById(id)))
            return new ResponseEntity<>(new ActionDto("La Ficha: " + id + " no existe"), HttpStatus.BAD_REQUEST);
        fichasService.disabledFicha(id);
        return new ResponseEntity<>(new ActionDto("viernes 21 de octubre y son las 11:22 de la noche :D"),
                HttpStatus.ACCEPTED);
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