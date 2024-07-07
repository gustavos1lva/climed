package com.example.climed.controller.model;

import java.time.Instant;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public record CreateConsultaRequest(

        String nomePaciente,
        String telefonePaciente,
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate date,
        Long crm,
        Long idEsp,
        Instant horaInicioCon
) {
}
