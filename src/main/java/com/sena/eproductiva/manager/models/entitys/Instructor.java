package com.sena.eproductiva.manager.models.entitys;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "instructores")
// Esta clase hereda los atributos y metodos de la clase Padre Usuario
public class Instructor extends Usuario {
    /*
     * @ManyToOne define una relacion de muchos a uno
     * 
     * @JoinColumn une las tablas por medio de una llave foranea (Centro)
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_INSTRUCTOR_CENTRO"))
    private Centro centro;

}