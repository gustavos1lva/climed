package com.example.climed.controller.model;

public record CreatePacienteRequest(
        String cpf,
        String nomePac,
        String telefonePac,
        String endereco,
        Integer idade,
        String sexo
) {}
