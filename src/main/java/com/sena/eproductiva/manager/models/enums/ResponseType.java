package com.sena.eproductiva.manager.models.enums;

import lombok.Getter;

public enum ResponseType {
    ENTITY_NOT_FOUND("Entidad no Encontrada"),
    ENTITY_CREATED("Entidad Creada"),
    ENTITY_EXIST("Entidad Existe"),
    INVALID_FIELDS("Campos Invalidos"),
    ENTITY_UPDATE("Entidad Actualizada"),
    ENTITY_DELETE("Entidad Eliminada"),
    ENTITY_DISABLE("Entidad Deshabilitada"),
    UNAUTHORIZED("No tienes permiso");

    @Getter
    private String message;

    /**
     * 
     * @param message recibe un tipo de respuesta
     */
    ResponseType(String message) {
        this.message = message;
    }
}