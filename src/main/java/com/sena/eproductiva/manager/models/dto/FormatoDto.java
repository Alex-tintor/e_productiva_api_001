package com.sena.eproductiva.manager.models.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class FormatoDto implements Serializable{

    private long id;
    private String instructor;
    private Date fecha;
    
}
