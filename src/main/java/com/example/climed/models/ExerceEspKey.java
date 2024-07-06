package com.example.climed.models;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public final class ExerceEspKey implements Serializable {
    @Serial private static final long serialVersionUID = 0L;
    private String crm;
    private Long idEsp;

    public ExerceEspKey(
            String crm,
            Long idEsp
    ) {
        this.crm = crm;
        this.idEsp = idEsp;
    }

    public ExerceEspKey() {
        /* empty on purpose */
    }

    public String getCrm() {
        return crm;
    }

    public Long getIdEsp() {
        return idEsp;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (ExerceEspKey)obj;
        return Objects.equals(this.crm, that.crm) &&
                Objects.equals(this.idEsp, that.idEsp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crm, idEsp);
    }

    @Override
    public String toString() {
        return "ExerceEspKey[" +
                "crm=" + crm + ", " +
                "idEsp=" + idEsp + ']';
    }

}
