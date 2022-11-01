package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FormatoDto extends ResponseDto{

    @NotNull
    private long id;
    @NotNull
    @NotBlank
    @NotEmpty
    private String instructor;
    @NotNull
    private Date fecha;
    
}
