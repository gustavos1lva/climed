package com.example.climed.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.climed.models.Consulta;
import com.example.climed.models.Medico;
import com.example.climed.models.Paciente;

@Repository
public interface MedicoRepository extends CrudRepository<Medico, Long> {
}
