package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AprendizDto implements Serializable {

    private long cc;
    private String nombre;
    private String apellido;
    private String email;
    private long telefono;
    private long fichaId;
    private String etapa;
    private boolean enabled;

    private static final long serialVersionUID = 1L;
}