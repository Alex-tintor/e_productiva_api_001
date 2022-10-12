package com.sena.eproductiva.manager.models.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "centros_de_formacion")
public class CentroFormacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uuid;

    @Column(length = 75, nullable = false)
    private String nombre;

    private boolean enabled = true;

}