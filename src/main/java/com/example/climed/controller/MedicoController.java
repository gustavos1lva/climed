package com.example.climed.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.climed.models.Medico;
import com.example.climed.repository.EspecialidadeRepository;
import com.example.climed.repository.MedicoRepository;

@Controller("/medico")
public class MedicoController {

    private final MedicoRepository medicoRepository;
    private final EspecialidadeRepository especialidadeRepository;

    public MedicoController(final MedicoRepository medicoRepository, final EspecialidadeRepository especialidadeRepository) {
        this.medicoRepository = medicoRepository;
        this.especialidadeRepository = especialidadeRepository;
    }

    @GetMapping("/nome")
    public List<Medico> getByName(@RequestParam("nome") String nome) {
        return medicoRepository.findByNomeMedico(nome);
    }

    @GetMapping("/especialidade")
    public List<Medico> getByEspecialidade(@RequestParam("especialidade") String especialidade) {
        return medicoRepository.findByEspecialidades(
                new HashSet<>(especialidadeRepository.findByNomeEsp(especialidade))
        );
    }

    @GetMapping("/nome_especialidade")
    public List<Medico> getByEspecialidade(@RequestParam("especialidade") String especialidade, @RequestParam("nome") String nome) {
        return medicoRepository.findByNomeMedicoAndEspecialidades(
                nome,
                new HashSet<>(especialidadeRepository.findByNomeEsp(especialidade))
        );
    }

    @GetMapping
    public Optional<Medico> getByEspecialidade(@RequestParam("crm") Long crm) {
        return medicoRepository.findById(crm);
    }

}
