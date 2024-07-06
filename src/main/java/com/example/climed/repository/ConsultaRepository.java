package com.example.climed.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.climed.models.Consulta;
import com.example.climed.models.Medico;
import com.example.climed.models.Paciente;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Long> {

    Consulta findConsultaByMedicoAndPaciente(final Medico medico, final Paciente paciente);

}
