package com.example.climed.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "diagnostico")
@Builder
public final class Diagnostico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idDiagnostico;
    private String tratamentoRecomendado;
    private String remediosReceitados;
    private String observacoes;
    @OneToOne @JoinColumn(name = "id_con"/*, referencedColumnName = "id_con"*/) private Consulta consulta;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "diagnostica", joinColumns = @JoinColumn(name = "id_diagnostico"), inverseJoinColumns = @JoinColumn(name = "id_doenca"))
    private Set<Doenca> doenca;

    public Diagnostico(
            Long idDiagnostico,

            String tratamentoRecomendado,
            String remediosReceitados,
            String observacoes,

            Consulta consulta,

            Set<Doenca> doenca
    ) {
        this.idDiagnostico = idDiagnostico;
        this.tratamentoRecomendado = tratamentoRecomendado;
        this.remediosReceitados = remediosReceitados;
        this.observacoes = observacoes;
        this.consulta = consulta;
        this.doenca = doenca;
    }

    public Diagnostico() {
        /* Empty on purpose */
    }

    public Long getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(final Long idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public String getTratamentoRecomendado() {
        return tratamentoRecomendado;
    }

    public void setTratamentoRecomendado(final String tratamentoRecomendado) {
        this.tratamentoRecomendado = tratamentoRecomendado;
    }

    public String getRemediosReceitados() {
        return remediosReceitados;
    }

    public void setRemediosReceitados(final String remediosReceitados) {
        this.remediosReceitados = remediosReceitados;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(final String observacoes) {
        this.observacoes = observacoes;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(final Consulta consulta) {
        this.consulta = consulta;
    }

    public Set<Doenca> getDoenca() {
        return doenca;
    }

    public void setDoenca(final Set<Doenca> doenca) {
        this.doenca = doenca;
    }

    @Override
    public String toString() {
        return "Diagnostico[" +
                "idDiagnostico=" + idDiagnostico + ", " +
                "tratamentoRecomendado=" + tratamentoRecomendado + ", " +
                "remediosReceitados=" + remediosReceitados + ", " +
                "observacoes=" + observacoes + ", " +
                "consulta=" + consulta + ", " +
                "doenca=" + doenca + ']';
    }

}
