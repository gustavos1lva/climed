package com.example.climed.models;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "especialidade")
@Builder
public final class Especialidade {
    //    @Column(name = "id_esp")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idEsp;
    private String nomeEsp;
    private Integer indice;
    @OneToMany(mappedBy = "especialidade") private Set<Consulta> consultas;

    public Especialidade(
            Long idEsp,

            String nomeEsp,
            Integer indice,

            Set<Consulta> consultas
    ) {
        this.idEsp = idEsp;
        this.nomeEsp = nomeEsp;
        this.indice = indice;
        this.consultas = consultas;
    }

    public Especialidade() {
        /* empty on purpose */
    }

    public Long getIdEsp() {
        return idEsp;
    }

    public String getNomeEsp() {
        return nomeEsp;
    }

    public Integer getIndice() {
        return indice;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (Especialidade)obj;
        return Objects.equals(this.idEsp, that.idEsp) &&
                Objects.equals(this.nomeEsp, that.nomeEsp) &&
                Objects.equals(this.indice, that.indice) &&
                Objects.equals(this.consultas, that.consultas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEsp, nomeEsp, indice, consultas);
    }

    @Override
    public String toString() {
        return "Especialidade[" +
                "idEsp=" + idEsp + ", " +
                "nomeE=" + nomeEsp + ", " +
                "indice=" + indice + ", " +
                "consultas=" + consultas + ']';
    }

}