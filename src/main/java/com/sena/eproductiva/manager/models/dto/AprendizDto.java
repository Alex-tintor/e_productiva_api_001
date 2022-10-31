package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AprendizDto implements Serializable {

    @NotBlank
    @NotEmpty
    @NotNull
    private String documento;
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
    private Long fichaId;
    @NotBlank
    @NotEmpty
    @NotNull
    private String etapa;
    @NotNull
    private boolean enabled;
}