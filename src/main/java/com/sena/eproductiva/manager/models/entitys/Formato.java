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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "formato")
public class Formato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "instructorCc")
    Instructor instructorEntity;

    @Column(nullable = false)
    private Date fecha;

}
