package com.example.climed.controller.model;

import java.time.Instant;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public record CreateConsultaRequest(

        String nomePaciente,
        String telefonePaciente,
        @DateTimeFormat(pattern = "dd-MM-yyyy")
        Date date,
        Long crm,
        Long idEsp,
        Instant horaInicioCon
) {
}
