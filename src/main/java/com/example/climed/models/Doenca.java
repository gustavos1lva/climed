package com.example.climed.models;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "doenca")
public final class Doenca {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idDoenca;
    private String nomeDoenca;
    @ManyToMany(mappedBy = "doenca") private Set<Diagnostico> diagnosticos;

    public Doenca(
            Long idDoenca,

            String nomeDoenca,

            Set<Diagnostico> diagnosticos
    ) {
        this.idDoenca = idDoenca;
        this.nomeDoenca = nomeDoenca;
        this.diagnosticos = diagnosticos;
    }

    public Doenca() {
        /* empty on purpose */
    }

    public Long getIdDoenca() {
        return idDoenca;
    }

    public String getNomeDoenca() {
        return nomeDoenca;
    }

    public Set<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (Doenca)obj;
        return Objects.equals(this.idDoenca, that.idDoenca) &&
                Objects.equals(this.nomeDoenca, that.nomeDoenca) &&
                Objects.equals(this.diagnosticos, that.diagnosticos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoenca, nomeDoenca, diagnosticos);
    }

    @Override
    public String toString() {
        return "Doenca[" +
                "idDoenca=" + idDoenca + ", " +
                "nomeD=" + nomeDoenca + ", " +
                "diagnosticos=" + diagnosticos + ']';
    }

}
