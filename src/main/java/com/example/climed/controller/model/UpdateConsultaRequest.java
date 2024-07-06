package com.example.climed.controller.model;

import java.time.Instant;

public record UpdateConsultaRequest(

        Long idConsulta,
        Instant horaFimCon,
        boolean pagou,
        Double valorPago,
        Long idDiagnostico,
        String formaPagamento

) {
}
