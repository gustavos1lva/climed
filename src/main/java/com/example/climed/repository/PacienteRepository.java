package com.example.climed.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.climed.models.Paciente;

@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Long> {
}
