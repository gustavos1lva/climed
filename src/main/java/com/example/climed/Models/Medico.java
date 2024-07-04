package com.example.climed.Models;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medico")
public record Medico(
        @Id
        String crm,

        String nomeM,
        String telefoneM,
        Double percentual,

        @OneToMany(mappedBy = "medico")
        Set<Agenda> agendas
) {}
