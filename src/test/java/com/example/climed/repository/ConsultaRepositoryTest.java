package com.example.climed.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.climed.models.Consulta;
import com.example.climed.models.Medico;
import com.example.climed.models.Paciente;

@SpringBootTest
class ConsultaRepositoryTest {

    @Autowired
    ConsultaRepository consultaRepository;

    @Test
    void Should_Find_Consulta_By_Medico_And_Paciente() {
        var medico = new Medico(100L, null, null, null, null);
        var paciente = new Paciente(101L, null, null, null, null, null, null, null);
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
