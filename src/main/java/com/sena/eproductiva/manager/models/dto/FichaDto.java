 package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class FichaDto implements Serializable {

    @NotNull
    private long id;
    @NotNull
    private String programaId;
    @NotBlank
    @NotEmpty
    @NotNull
    private String modalidad;
    @NotNull
    private String instructor;
    @NotNull
    private Long centroId;
    @NotNull
    private Date inicio;
    @NotNull
    private Date fin;
    @NotNull
    private boolean enabled;
}
