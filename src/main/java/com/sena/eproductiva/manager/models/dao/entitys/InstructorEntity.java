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
@Table(name = "instructores")
public class InstructorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cc;

    @Column(nullable = false)
    @Size(min = 3,max = 45)
    private String nombre;

    @Column(nullable = false)
    @Size(min = 3,max = 45)
    private String apellido;

    @Column(nullable = false)
    @Size(min = 10,max = 45)
    private String correo;

    @Column(nullable = false)
    private int telefono;

    @Column(nullable = false)
    private boolean enabled;

}