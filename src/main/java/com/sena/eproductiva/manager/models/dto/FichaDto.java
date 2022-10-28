 package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FichaDto implements Serializable {

    @NotBlank
    @NotEmpty
    @NotNull
    private long id;
    @NotBlank
    @NotEmpty
    @NotNull
    private String programaId;
    @NotBlank
    @NotEmpty
    @NotNull
    private String modalidad;
    @NotBlank
    @NotEmpty
    @NotNull
    private String instructor;
    @NotBlank
    @NotEmpty
    @NotNull
    private long centroId;
    @NotBlank
    @NotEmpty
    @NotNull
    private Date inicio;
    @NotBlank
    @NotEmpty
    @NotNull
    private Date fin;
    @NotBlank
    @NotEmpty
    @NotNull
    private boolean enabled;
}
