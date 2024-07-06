package com.example.climed.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.climed.models.Especialidade;
import com.example.climed.models.Medico;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Long> {

    List<Medico> findByNomeMedico(String nomeMedico);

    List<Medico> findByEspecialidades(Set<Especialidade> especialidades);

    List<Medico> findByNomeMedicoAndEspecialidades(String nomeMedico, Set<Especialidade> especialidades);
}
