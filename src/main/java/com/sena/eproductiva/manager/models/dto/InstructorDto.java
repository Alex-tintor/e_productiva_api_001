package com.sena.eproductiva.manager.models.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class InstructorDto extends ResponseDto {

    @NotNull
    @NotBlank
    @NotEmpty
    private String documento;
    @NotNull
    @NotBlank
    @NotEmpty
    private String documentoType;
    @NotNull
    @NotBlank
    @NotEmpty
    private String nombre;
    @NotNull
    @NotBlank
    @NotEmpty
    private String apellido;
    @Email
    private String email;
    @NotNull
    @NotBlank
    @NotEmpty
    private String telefono;
    @NotNull
    @NotEmpty
    // @Positive
    private String centro;
    @NotNull
    private boolean enabled;

}