package com.example.climed.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.climed.models.Consulta;
import com.example.climed.models.Medico;
import com.example.climed.models.Paciente;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta, Long> {

    List<Consulta> findConsultaByMedicoAndPaciente(final Medico medico, final Paciente paciente);

    List<Consulta> findConsultaByMedico_CrmAndPaciente_IdPac(final Long crm, final Long idPac);

}
