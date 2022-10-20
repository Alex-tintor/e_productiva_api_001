package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AprendizDto implements Serializable {

    @NotBlank
    @NotEmpty
    @NotNull
    private String cc;

    @NotBlank
    @NotEmpty
    @NotNull
    private String documentoType;

    @NotBlank
    @NotEmpty
    @NotNull
    private String nombre;

    @NotBlank
    @NotEmpty
    @NotNull
    private String apellido;

    @NotBlank
    @NotEmpty
    @NotNull
    private String email;

    @NotBlank
    @NotEmpty
    @NotNull
    private String telefono;

    @NotBlank
    @NotEmpty
    @NotNull
    private long fichaId;

    @NotBlank
    @NotEmpty
    @NotNull
    private String etapa;

    @NotBlank
    @NotEmpty
    @NotNull
    private boolean enabled;

    private static final long serialVersionUID = 1L;
}