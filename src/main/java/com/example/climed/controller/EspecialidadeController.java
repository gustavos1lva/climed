package com.example.climed.controller;

import static com.example.climed.controller.EspecialidadeController.ENDPOINT;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getByName(@RequestParam("nome") String nome) {
        if (nome == null || nome.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Nome cannot be empty nor null");
        }

        List<Especialidade> especialidades = especialidadeRepository.findByNomeEsp(nome);
        return ResponseEntity.ok(especialidades);
    }


    @GetMapping(ENDPOINT)
    public ResponseEntity<?> getById(@RequestParam("id") Long idEsp) {
        if (idEsp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Id cannot be null");
        }

        Optional<Especialidade> especialidade = especialidadeRepository.findById(idEsp);
        if (especialidade.isPresent()) {
            return ResponseEntity.ok(especialidade);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Especialidade not found");
        }
    }
}
