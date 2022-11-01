package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserDto extends ResponseDto {
    
    @NotBlank
    @NotEmpty
    @NotNull
    private String uuid;
    @NotBlank
    @NotEmpty
    @NotNull
    private String documento;
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
    private boolean enabled;
    @NotBlank
    @NotEmpty
    @NotNull
    private String documentoType;
    
}
