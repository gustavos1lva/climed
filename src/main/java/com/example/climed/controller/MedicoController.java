package com.example.climed.controller;

import static com.example.climed.controller.MedicoController.ENDPOINT;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.climed.models.Medico;
import com.example.climed.repository.EspecialidadeRepository;
import com.example.climed.repository.MedicoRepository;

@RestController(ENDPOINT)
public class MedicoController {
    public static final String ENDPOINT = "medico";

    private final MedicoRepository medicoRepository;
    private final EspecialidadeRepository especialidadeRepository;

    public MedicoController(final MedicoRepository medicoRepository, final EspecialidadeRepository especialidadeRepository) {
        this.medicoRepository = medicoRepository;
        this.especialidadeRepository = especialidadeRepository;
    }

    @GetMapping(ENDPOINT + "/nome")
    public List<Medico> getByName(@RequestParam("nome") String nome) {
        return medicoRepository.findByNomeMedico(nome);
    }

    @GetMapping(ENDPOINT + "/especialidade")
    public List<Medico> getByEspecialidade(@RequestParam("especialidade") String especialidade) {
        return medicoRepository.findByEspecialidades(
                new HashSet<>(especialidadeRepository.findByNomeEsp(especialidade))
        );
    }

    @GetMapping(ENDPOINT + "/nome_especialidade")
    public List<Medico> getByNomeAndEspecialidade(@RequestParam("especialidade") String especialidade, @RequestParam("nome") String nome) {
        return medicoRepository.findByNomeMedicoAndEspecialidades(
                nome,
                new HashSet<>(especialidadeRepository.findByNomeEsp(especialidade))
        );
    }

    @GetMapping(ENDPOINT)
    public Optional<Medico> getByCrm(@RequestParam("crm") Long crm) {
        return medicoRepository.findById(crm);
    }

}
