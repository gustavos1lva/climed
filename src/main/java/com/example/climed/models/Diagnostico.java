package com.example.climed.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "diagnostico")
public final class Diagnostico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idDiagnostico;
    private String tratamentoRecomendado;
    private String remediosReceitados;
    private String observacoes;
    @OneToOne @JoinColumn(name = "id_con"/*, referencedColumnName = "id_con"*/) private Consulta consulta;
    @ManyToOne @JoinColumn(name = "id_doenca"/*, referencedColumnName = "id_doenca"*/) private Doenca doenca;

    public Diagnostico(
            Long idDiagnostico,

            String tratamentoRecomendado,
            String remediosReceitados,
            String observacoes,

            Consulta consulta,

            Doenca doenca
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

    public Doenca getDoenca() {
        return doenca;
    }

    public void setDoenca(final Doenca doenca) {
        this.doenca = doenca;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (Diagnostico)obj;
        return Objects.equals(this.idDiagnostico, that.idDiagnostico) &&
                Objects.equals(this.tratamentoRecomendado, that.tratamentoRecomendado) &&
                Objects.equals(this.remediosReceitados, that.remediosReceitados) &&
                Objects.equals(this.observacoes, that.observacoes) &&
                Objects.equals(this.consulta, that.consulta) &&
                Objects.equals(this.doenca, that.doenca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDiagnostico, tratamentoRecomendado, remediosReceitados, observacoes, consulta, doenca);
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
