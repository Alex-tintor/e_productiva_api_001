package com.sena.eproductiva.manager.models.dto;

import lombok.Getter;

@Getter
public class ActionDto extends ResponseDto {
    
    private String message;

    public ActionDto(String response) {
        this.message = response;
    }

}