package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CentroFormacionDto implements Serializable {

    private long uuid;

    private String nombre;

    private boolean enabled;

    public static final long serialVersionUID = 1L;
}
