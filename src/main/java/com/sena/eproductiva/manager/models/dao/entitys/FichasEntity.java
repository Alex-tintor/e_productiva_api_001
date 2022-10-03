package com.sena.eproductiva.manager.models.dao.entitys;

import java.sql.Date;

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
@Table(name="fichas")
public class FichasEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private String id;

    private long programa_id;

    @Column(nullable = false)
    private String modalidad;

    private int instructor_id;

    private int centro_id;
    
    @Column(nullable = false)
    private Date inicio;

    @Column(nullable = false)
    private Date fin;

    @Column(nullable = false)
    private Byte enabled;

    
}
