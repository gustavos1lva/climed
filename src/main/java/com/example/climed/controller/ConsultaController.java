package com.example.climed.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.climed.controller.model.CreateConsultaRequest;
import com.example.climed.controller.model.UpdateConsultaRequest;
import com.example.climed.models.Consulta;
import com.example.climed.models.Diagnostico;
import com.example.climed.models.Especialidade;
import com.example.climed.models.Medico;
import com.example.climed.models.Paciente;
import com.example.climed.repository.ConsultaRepository;
import com.example.climed.repository.PacienteRepository;

@RestController(ConsultaController.ENDPOINT)
public class ConsultaController {
    public static final String ENDPOINT = "consulta";

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;

    public ConsultaController(final ConsultaRepository consultaRepository, final PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping(ENDPOINT + "/especialidade")
    public List<Consulta> getByDateAndEspecialidade(
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam("especialidade") String especialidade
    ) {
        return consultaRepository.findConsultaByDataAndEspecialidade_NomeEsp(date, especialidade);
    }

    @GetMapping(ENDPOINT + "/medico")
    public List<Consulta> getByDateAndEspecialidadeAndMedico(
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam("especialidade") String especialidade,
            @RequestParam("medico") String medico
    ) {
        return consultaRepository.findConsultaByDataAndEspecialidade_NomeEspAndMedico_NomeMedico(date, especialidade, medico);
    }

    @PostMapping(ENDPOINT)
    public Consulta createConsulta(@RequestBody CreateConsultaRequest createConsultaRequest) {
        var paciente = pacienteRepository.findByNomePacAndTelefonePac(createConsultaRequest.nomePaciente(), createConsultaRequest.telefonePaciente())
                .orElseGet(() -> pacienteRepository.save(
                                Paciente.builder()
                                        .nomePac(createConsultaRequest.nomePaciente())
                                        .telefonePac(createConsultaRequest.telefonePaciente())
                                        .build()
                        )
                );

        return consultaRepository.save(
                Consulta.builder()
                        .paciente(paciente)
                        .medico(Medico.builder().crm(createConsultaRequest.crm()).build())
                        .especialidade(Especialidade.builder().idEsp(createConsultaRequest.idEsp()).build())
                        .horaInicCon(createConsultaRequest.horaInicioCon())
                        .build()
        );

    }

    @PutMapping(ENDPOINT)
    public Consulta updateConsulta(@RequestBody UpdateConsultaRequest updateConsultaRequest) {

        var consulta = consultaRepository.findById(updateConsultaRequest.idConsulta())
                .orElseThrow();

        if(updateConsultaRequest.horaFimCon() != null) {
            consulta.setHoraFimCon(updateConsultaRequest.horaFimCon());
        }
        if(updateConsultaRequest.valorPago() != null) {
            consulta.setValorPago(updateConsultaRequest.valorPago());
        }
        if(updateConsultaRequest.idDiagnostico() != null) {
            consulta.setDiagnostico(Diagnostico.builder().idDiagnostico(updateConsultaRequest.idDiagnostico()).build());
        }
        if(updateConsultaRequest.formaPagamento() != null) {
            consulta.setFormaPagamento(updateConsultaRequest.formaPagamento());
        }

        consulta.setPagou(updateConsultaRequest.pagou()); // boolean primitive cannot be null

        return consultaRepository.save(consulta);
    }
}
