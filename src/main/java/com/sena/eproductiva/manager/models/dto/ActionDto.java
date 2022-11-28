package com.sena.eproductiva.manager.models.dto;

import lombok.Getter;

@Getter
public class ActionDto extends ResponseDto {

    private String message;

    /**
     * Constructor
     * 
     * @param response recibe una respuesta del servidor
     */
    public ActionDto(String response) {
        this.message = response;
    }

}