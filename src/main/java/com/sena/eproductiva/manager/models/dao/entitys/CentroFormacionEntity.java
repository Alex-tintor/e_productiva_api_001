package com.sena.eproductiva.manager.models.dao.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 

@Entity
@Table(name = "centros_de_formacion")
public class CentroFormacionEntity { 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long uuid;

    @Column(length = 75,nullable = false)
    @Size(min = 1,max = 70)
    private String nombre;
    
    private boolean enabled = true;

}