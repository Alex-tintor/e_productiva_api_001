package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class InstructorDto implements Serializable{

    private long cc;

    private String nombre;

    private String apellido;

    private String email;

    private int telefono;

    private long centroId;

    private boolean enabled;
    
}
