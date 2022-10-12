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
public class FichaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "programaId")
    ProgramaFormacionEntity programaFormacionEntity;

    @Column(nullable = false, length = 30)
    private String modalidad;

    @ManyToOne
    @JoinColumn(name = "instructorCc")
    InstructorEntity instructorEntity;

    @ManyToOne
    @JoinColumn(name = "centroId")
    CentroFormacionEntity centroFormacionEntity;

    @Column(nullable = false)
    private Date inicio;

    @Column(nullable = false)
    private Date fin;

    private boolean enabled;

}