package com.sena.eproductiva.manager.models.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.sena.eproductiva.manager.models.enums.ResponseType;

import lombok.Getter;

@Getter
public class InvalidDto extends ResponseDto {

    private List<String> errors;
    private String message;
    private String timestamp;
    private String path;

    /**
     * Constructor
     * 
     * @param message recibe un tipo de respuesta
     * @param errors  recibe una lista de errores
     * @param path    recibe la ruta donde se dio el error
     */
    public InvalidDto(ResponseType message, List<String> errors, String path) {
        this.message = message.getMessage();
        this.errors = errors;
        this.timestamp = new Timestamp(System.currentTimeMillis()).toString();
        this.path = path;
    }

    /**
     * Constructor
     * 
     * @param message recibe un tipo de respuesta
     * @param path    recibe la ruta donde se dio el error
     */
    public InvalidDto(ResponseType message, String path) {
        this.message = message.getMessage();
        this.errors = new ArrayList<>();
        this.timestamp = new Timestamp(System.currentTimeMillis()).toString();
        this.path = path;
    }

}