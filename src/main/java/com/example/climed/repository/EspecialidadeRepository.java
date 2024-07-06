package com.example.climed.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.climed.models.Especialidade;

@Repository
public interface EspecialidadeRepository extends CrudRepository<Especialidade, Long> {

    List<Especialidade> findByNomeEsp(final String nomeEsp);
}
