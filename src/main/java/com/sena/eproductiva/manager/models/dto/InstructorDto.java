package com.sena.eproductiva.manager.models.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class InstructorDto extends ResponseDto {

    private String documento;
    private String documentoType;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private long centro;
    private boolean enabled;

}