package com.sena.eproductiva.manager.models.entitys;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "fichas")
public class Ficha implements GeneralEntity {

    @Id
    @Column(length = 36)
    private String id;

    @ManyToOne
    @JoinColumn(name = "programaId")
    Programa programaFormacionEntity;

    @Column(nullable = false, length = 30)
    private String modalidad;

    @ManyToOne
    @JoinColumn(name = "instructor")
    Instructor instructorEntity;

    @ManyToOne
    @JoinColumn(name = "centroId")
    Centro centroFormacionEntity;

    @Column(nullable = false)
    private Date inicio;

    @Column(nullable = false)
    private Date fin;

    private boolean enabled;

}