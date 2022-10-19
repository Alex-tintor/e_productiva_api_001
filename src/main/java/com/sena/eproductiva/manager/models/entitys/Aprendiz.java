package com.sena.eproductiva.manager.models.entitys;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.sena.eproductiva.manager.models.enums.EtapaType;

import lombok.Data;

@Data
@Entity
@Table(name = "aprendices")
public class Aprendiz {

    // TODO los atributos de esta clase se optimizaron, no solo en clase sino en el
    // tamaño que ocupan en la tabla, nombres cortos y sensillos

    // se implementa uuid unica para tener livertad de usar la cedula o TI sin
    // afectar la integridad unica de la PK
    @Id
    @Column(length = 36)
    private String uuid;

    // se cambia el nombre de cc a documento, para estudiantes que tengan tarjeta de
    // identidad y cedula
    @Column(nullable = false, length = 12)
    private String documento;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(nullable = false, length = 45)
    private String apellido;

    @Column(nullable = false, length = 45)
    private String email;

    @Column(nullable = false, length = 11)
    private long telefono;

    // TODO agregamos carga perezosa, y le damos un FK personalizado
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_APRENDIZ_FICHA"))
    private Ficha ficha;

    // TODO convertir esto en un ENUM
    @Column(nullable = false, length = 11)
    private EtapaType etapa;

    @Column(nullable = false)
    private boolean enabled = true;

    // TODO Confirmar el timpo de informacion
    // antes de guardarse en la db
    @PrePersist
    private void confirmarInformacion() {
        if (this.uuid == null || this.uuid.length() < 32) {
            this.uuid = UUID.randomUUID().toString().replace("-", "");
        }
        if (this.etapa == null)
            this.etapa = EtapaType.LECTIVA;
    }

}