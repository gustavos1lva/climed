package com.example.climed.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.climed.models.Consulta;

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
        var consultaEsperada = new Consulta(1L, medico, null, paciente, null, null, null, null, null, null, null);

        var consulta = consultaRepository.findConsultaByMedicoAndPaciente(
                medico,
                paciente
        );
        assertThat(consulta)
                .isNotNull()
                .isEqualTo(consultaEsperada)
        ;
    }
}
