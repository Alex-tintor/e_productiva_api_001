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
@Table(name = "aprendices")
public class AprendizEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cedula;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, length = 45)
    private String apellido;

    @Column(nullable = false, length = 45)
    private String email;

    @Column(nullable = false)
    private long telefono;

    @ManyToOne
    @JoinColumn(name = "fichaId")
    private FichaEntity fichaEntity;

    @Column(nullable = false)
    private String etapa;

    private boolean enabled = true;

}