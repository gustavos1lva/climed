package com.example.climed.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.climed.models.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Long> {

    Optional<Paciente> findByNomePacAndTelefonePac(String nomePac, String telefonePac);

    Optional<Paciente> findByCpf(String cpf);
}
