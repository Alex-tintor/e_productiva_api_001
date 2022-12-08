package com.sena.eproductiva.manager.models.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FichaDto extends ResponseDto {

    @NotNull
    private String id;
    @NotNull
    private String programaId;
    @NotBlank
    @NotEmpty
    @NotNull
    private String modalidad;
    @NotNull
    private String instructor;
    @NotNull
    private String centroId;
    @NotNull
    private Date inicio;
    @NotNull
    private Date fin;
    @NotNull
    private boolean enabled;
}
