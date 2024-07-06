package com.example.climed.controller;

import static com.example.climed.controller.EspecialidadeController.ENDPOINT;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.climed.models.Especialidade;
import com.example.climed.repository.EspecialidadeRepository;

@RestController(ENDPOINT)
public class EspecialidadeController {
    public static final String ENDPOINT = "especialidade";

    private final EspecialidadeRepository especialidadeRepository;

    public EspecialidadeController(final EspecialidadeRepository especialidadeRepository) {
        this.especialidadeRepository = especialidadeRepository;
    }

    @GetMapping(ENDPOINT + "/nome")
    public List<Especialidade> getByName(@RequestParam("nome") String nome) {
        return especialidadeRepository.findByNomeEsp(nome);
    }

    @GetMapping(ENDPOINT)
    public Optional<Especialidade> getById(@RequestParam("id") Long idEsp) {
        return especialidadeRepository.findById(idEsp);
    }

}
