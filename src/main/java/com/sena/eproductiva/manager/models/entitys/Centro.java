package com.sena.eproductiva.manager.models.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "centros")
public class Centro implements GeneralEntity {

    @Id
    @Column(length = 36)
    private String uuid;

    @Column(length = 75, nullable = false)
    private String nombre;

    private boolean enabled;

}