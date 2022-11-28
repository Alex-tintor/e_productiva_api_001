package com.sena.eproductiva.manager.models.entitys;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
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

    @PrePersist
    private void confirmarInformacion() {
        if (this.uuid == null || this.uuid.length() < 32) {
            this.uuid = UUID.randomUUID().toString().replace("-", "");
        }
    }

}