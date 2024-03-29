package com.sena.eproductiva.manager.models.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProgramaDto extends ResponseDto {

    // @NotNull
    // @NotBlank
    // @NotEmpty
    private String id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String nombre;
    @NotNull
    @NotBlank
    @NotEmpty
    private String nivel;
    @NotNull
    private boolean enabled;
}
