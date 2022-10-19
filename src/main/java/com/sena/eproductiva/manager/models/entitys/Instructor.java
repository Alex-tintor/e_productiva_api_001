package com.sena.eproductiva.manager.models.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "instructores")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cc;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(nullable = false, length = 45)
    private String apellido;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int telefono;

    @ManyToOne
    @JoinColumn(name = "centroId")
    private Centro centroFormacionEntity;

    @Column(nullable = false)
    private boolean enabled;

}