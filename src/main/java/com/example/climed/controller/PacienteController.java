package com.example.climed.controller;

import static com.example.climed.controller.PacienteController.ENDPOINT;

import java.util.Optional;

import com.example.climed.models.Paciente;
import com.example.climed.repository.PacienteRepository;
import com.example.climed.controller.model.CreatePacienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(ENDPOINT)
public class PacienteController {
    public static final String ENDPOINT = "paciente";
    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @PostMapping("/salvar")
    public ResponseEntity<String> salvarPaciente(@RequestBody CreatePacienteRequest request) {
        try {
            Paciente paciente = Paciente.builder()
                    .cpf(request.cpf())
                    .nomePac(request.nomePac())
                    .telefonePac(request.telefonePac())
                    .endereco(request.endereco())
                    .idade(request.idade())
                    .sexo(request.sexo())
                    .build();

            Paciente novoPaciente = pacienteRepository.save(paciente);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Paciente salvo com sucesso. ID: " + novoPaciente.getIdPac());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar paciente: " + e.getMessage());
        }
    }

    @GetMapping("/buscarPorCpf")
    public ResponseEntity<?> buscarPorCpf(@RequestParam String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: CPF cannot be null");
        }

        Optional<Paciente> paciente = pacienteRepository.findByCpf(cpf);
        if (paciente.isPresent()) {
            return ResponseEntity.ok(paciente);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Paciente not found");
        }
    }
}
