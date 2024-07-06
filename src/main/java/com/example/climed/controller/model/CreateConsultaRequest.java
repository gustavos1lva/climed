package com.example.climed.controller.model;

import java.time.Instant;
import java.util.Date;

public record CreateConsultaRequest(

        String nomePaciente,
        String telefonePaciente,
        Date date,
        Long crm,
        Long idEsp,
        Instant horaInicioCon
) {
}
