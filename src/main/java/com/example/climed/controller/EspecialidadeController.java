package com.example.climed.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.climed.models.Especialidade;
import com.example.climed.repository.EspecialidadeRepository;

@Controller("/especialidade")
public class EspecialidadeController {

    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeController(final EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    @GetMapping("/nome")
    public List<Especialidade> getByName(@RequestParam("nome") String nome) {
        return especialidadeRepository.findByNomeEsp(nome);
    }

    @GetMapping
    public Optional<Especialidade> getById(@RequestParam("id") Long idEsp) {
        return especialidadeRepository.findById(idEsp);
    }

}
