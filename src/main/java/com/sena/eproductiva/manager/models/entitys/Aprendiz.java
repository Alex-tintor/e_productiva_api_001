package com.sena.eproductiva.manager.models.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sena.eproductiva.manager.models.enums.EtapaType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "aprendices")
public class Aprendiz extends Usuario {

    /*
     * @ManyToOne define relacion muchos a uno.
     * 
     * @JoinColumn une las tables que se relacionan por medio de una FK.
     * Una Ficha puede tener muchos Aprendiz,
     * Un Aprendiz solo puede pertenecer a una Ficha
     */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_APRENDIZ_FICHA"))
    private Ficha ficha;

    @Column(nullable = false, length = 11, name = "etapa")
    private String etapa;
}