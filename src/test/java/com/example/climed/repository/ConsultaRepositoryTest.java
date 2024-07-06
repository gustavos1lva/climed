package com.example.climed.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.climed.models.Consulta;
import com.example.climed.models.Especialidade;
import com.example.climed.models.Medico;
import com.example.climed.models.Paciente;

@SpringBootTest
class ConsultaRepositoryTest {

    @Autowired
    ConsultaRepository consultaRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Test
    void Should_Find_Consulta_By_Medico_And_Paciente() {
        var medico = medicoRepository.findById(123456L).get();
        var paciente = pacienteRepository.findById(101L).get();

        var consulta = consultaRepository.findConsultaByMedicoAndPaciente(
                medico,
                paciente
        );
        assertThat(consulta)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
                .allMatch(c -> c.getPaciente().getIdPac() == 101L)
                .allMatch(c -> c.getMedico().getCrm() == 123456L)
        ;
    }

    @Test
    void Should_Find_Consulta_By_Crm_And_IdPac() {
        var crm = 123456L;
        var idPac = 101L;

        var consulta = consultaRepository.findConsultaByMedico_CrmAndPaciente_IdPac(
                crm,
                idPac
        );

        assertThat(consulta)
                .isNotNull()
                .isNotEmpty()
                .hasSize(2)
                .allMatch(c -> c.getPaciente().getIdPac() == 101L)
                .allMatch(c -> c.getMedico().getCrm() == 123456L)
        ;
    }

    @Test
    void Should_Create_Consulta_Without_Querying_Medico_And_Paciente_And_Especialidade() {
        var crm = 123456L;
        var idPac = 101L;
        var idEsp = 11L;

        assertDoesNotThrow(
                () -> consultaRepository.save(

                        Consulta.builder()
                                .medico(Medico.builder().crm(crm).build())
                                .paciente(Paciente.builder().idPac(idPac).build())
                                .especialidade(Especialidade.builder().idEsp(idEsp).build())
                                .data(Date.from(Instant.now()))
                                .horaInicCon(Instant.now())
                                .build()
                )
        );
    }
}
