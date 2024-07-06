package com.example.climed.models;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "exerce_esp")
public final class ExerceEsp {
    @EmbeddedId private ExerceEspKey id;

    public ExerceEsp(
            ExerceEspKey id
    ) {
        this.id = id;
    }

    public ExerceEsp() {
        /* empty on purpose */
    }

    public ExerceEspKey getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (ExerceEsp)obj;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ExerceEsp[" +
                "id=" + id + ']';
    }

}
