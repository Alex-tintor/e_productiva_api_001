package com.sena.eproductiva.manager.models.dao.entitys;

import java.sql.Date;

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
@Table(name = "fichas")
public class FichasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Size(min = 1,max = 10)
    private long id;

    @Column(nullable = false)
    @Size(min = 1,max = 10)
    private String modalidad;

    @Column(nullable = false)
    private Date inicio;

    @Column(nullable = false)
    private Date fin;

    @Column(nullable = false)
    private boolean enabled;

}