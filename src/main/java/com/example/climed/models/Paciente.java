package com.example.climed.models;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "paciente")
@Builder
public final class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPac;
    private String cpf;
    private String nomePac;
    private String telefonePac;
    private String endereco;
    private Integer idade;
    private String sexo;
    @JsonIgnore
    @OneToMany(mappedBy = "paciente")
    private Set<Consulta> consultas;

    public Paciente(
            Long idPac,

            String cpf,
            String nomePac,
            String telefonePac,
            String endereco,
            Integer idade,
            String sexo,

            Set<Consulta> consultas) {
        this.idPac = idPac;
        this.cpf = cpf;
        this.nomePac = nomePac;
        this.telefonePac = telefonePac;
        this.endereco = endereco;
        this.idade = idade;
        this.sexo = sexo;
        this.consultas = consultas;
    }

    public Paciente() {
    }

    public Long getIdPac() {
        return idPac;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNomePac() {
        return nomePac;
    }

    public String getTelefonePac() {
        return telefonePac;
    }

    public String getEndereco() {
        return endereco;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getSexo() {
        return sexo;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    @Override
    public String toString() {
        return "Paciente[" +
                "idPac=" + idPac + ", " +
                "cpf=" + cpf + ", " +
                "nomeP=" + nomePac + ", " +
                "telefonePac=" + telefonePac + ", " +
                "endereco=" + endereco + ", " +
                "idade=" + idade + ", " +
                "sexo=" + sexo + ", " +
                "consultas=" + consultas + ']';
    }

}
