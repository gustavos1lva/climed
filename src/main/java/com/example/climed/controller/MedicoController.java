package com.example.climed.controller;

import static com.example.climed.controller.MedicoController.ENDPOINT;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.climed.models.Especialidade;
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
    public ResponseEntity<?> getByName(@RequestParam("nome") String nome) {
        List<Medico> medicos = medicoRepository.findByNomeMedico(nome);
        if (medicos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Medico not found");
        }
        return ResponseEntity.ok(medicos);
    }

    @GetMapping(ENDPOINT + "/especialidade")
    public ResponseEntity<?> getByEspecialidade(@RequestParam("especialidade") String especialidade) {
        List<Especialidade> especialidades = especialidadeRepository.findByNomeEsp(especialidade);
        if (especialidades.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Especialidade not found");
        }
        
        List<Medico> medicos = medicoRepository.findByEspecialidades(new HashSet<>(especialidades));
        if (medicos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: No Medico found for the given Especialidade");
        }
        
        return ResponseEntity.ok(medicos);
    }
    
    @GetMapping(ENDPOINT + "/nome_especialidade")
    public ResponseEntity<?> getByNomeAndEspecialidade(@RequestParam("especialidade") String especialidade, @RequestParam("nome") String nome) {
        List<Especialidade> especialidades = especialidadeRepository.findByNomeEsp(especialidade);
        if (especialidades.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Especialidade not found");
        }
    
        List<Medico> medicos = medicoRepository.findByNomeMedicoAndEspecialidades(
                nome,
                new HashSet<>(especialidades)
        );
        if (medicos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: No Medico found for the given Nome and Especialidade");
        }
    
        return ResponseEntity.ok(medicos);
    }

    @GetMapping(ENDPOINT)
    public ResponseEntity<?> getByCrm(@RequestParam("crm") Long crm) {
        Optional<Medico> medico = medicoRepository.findById(crm);
        if (!medico.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Medico not found");
        }
        return ResponseEntity.ok(medico.get());
    }

}
