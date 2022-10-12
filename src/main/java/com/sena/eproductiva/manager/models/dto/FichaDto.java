package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class FichaDto implements Serializable {

    private long id;

    private long programaId;
    
    private String modalidad;

    private long instructorCc;

    private long centroId;

    private Date inicio;

    private Date fin;

    private boolean enabled;
    
    private static final long serialVersionUID = 1L;
}
