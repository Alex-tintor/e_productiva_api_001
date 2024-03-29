package com.sena.eproductiva.manager.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AprendizDto extends ResponseDto {

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
    @NotNull
    private String fichaId;
    @NotBlank
    @NotEmpty
    @NotNull
    private String etapa;
    @NotNull
    private boolean enabled;
}