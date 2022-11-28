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

@Data // Genera Getter, Setter, RequiredArgsConstructor, ToString, EqualsAndHashCode
@Inheritance(strategy = InheritanceType.JOINED)
@Entity // Especifica que la clase es una Entidad en BD.
// Clase padre que hereda a Aprendiz e Instructor
public class Usuario implements GeneralEntity {

    @Id // Especifica la llave primaria de la Entidad
    @Column(length = 36) // Especifica una columna en la Entidad con un tamaño de 36 caracteres
    private String uuid;

    @Column(nullable = false, length = 12, unique = true)
    private String documento;

    @Column(nullable = false, length = 45)
    private String nombre;

    @Column(nullable = false, length = 45)
    private String apellido;

    @Column(nullable = false, length = 70, unique = true) // Especifica que la columna es not null, de maximo 70
                                                          // caracteres y de llave unica
    private String email;

    @Column(nullable = false, length = 11, unique = true)
    private String telefono;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false, name = "tipo_documento")
    private DocumentoType type;

    /*
     * Este metodo agrega un valor al azar al atributo uuid de tipo String si el
     * uuid es vacio o menor a 32 caracteres
     */
    @PrePersist
    private void confirmarInformacion() {
        if (this.uuid == null || this.uuid.length() < 32) {
            this.uuid = UUID.randomUUID().toString().replace("-", "");
        }
    }

}