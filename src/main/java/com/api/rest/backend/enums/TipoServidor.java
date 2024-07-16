package com.api.rest.backend.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoServidor {
	PROFESSOR,
    TECNICO;
    
    @JsonCreator
    public static TipoServidor fromString(String key) {
        return key == null ? null : TipoServidor.valueOf(key.toUpperCase());
    }

    @JsonValue
    public String toValue() {
        return name();
    }
}
