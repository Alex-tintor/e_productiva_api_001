package com.sena.eproductiva.manager.models.entitys;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;

import com.sena.eproductiva.manager.models.enums.DocumentoType;

import lombok.Data;

@Data
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class Usuario implements GeneralEntity{

    @Id
    @Column(length = 36)
    private String uuid;

    @Column(nullable = false, length = 12, unique = true)
    private String documento;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(nullable = false, length = 45)
    private String apellido;

    @Column(nullable = false, length = 70, unique = true)
    private String email;

    @Column(nullable = false, length = 11, unique = true)
    private String telefono;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false, name = "tipo_documento")
    private DocumentoType type;

    @PrePersist
    private void confirmarInformacion() {
        if (this.uuid == null || this.uuid.length() < 32) {
            this.uuid = UUID.randomUUID().toString().replace("-", "");
        }
    }

}