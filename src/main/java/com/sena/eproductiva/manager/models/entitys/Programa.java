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
@Table(name = "programas")
public class Programa implements GeneralEntity{

    @Id
    @Column(length = 36)
    private String id;

    @Column(length = 75, nullable = false)
    private String nombre;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable=false)
    private String nivel;

    @PrePersist
    private void confirmarInformacion() {
        if (this.id == null || this.id.length() < 32) {
            this.id = UUID.randomUUID().toString().replace("-", "");
        }
    }
}
