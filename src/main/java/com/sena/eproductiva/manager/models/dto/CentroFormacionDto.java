package com.sena.eproductiva.manager.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CentroFormacionDto extends ResponseDto {

    @NotNull
    private String uuid;
    @NotBlank
    @NotEmpty
    @NotNull
    private String nombre;
    @NotNull
    private boolean enabled;
}