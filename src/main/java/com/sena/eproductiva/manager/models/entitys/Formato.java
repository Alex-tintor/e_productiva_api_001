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
@Table(name = "formato")
public class Formato implements GeneralEntity {

    @Id
    @Column(length = 36)
    private String id;

    /*
     * @ManyToOne define una relacion de muchos a uno
     * 
     * @JoinColumn une las tablas por medio de una llave foranea (Instructor)
     */
    @ManyToOne
    @JoinColumn(name = "instructor") // Preguntar por la foreing key
    private Instructor instructor;

    @Column(nullable = false)
    private Date fecha;
    

}
