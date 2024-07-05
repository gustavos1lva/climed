package com.example.climed.models;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "medico")
public record Medico(
        @Id
        Long crm,

        String nomeM,
        String telefoneM,
        Double percentual,

        @OneToMany(mappedBy = "medico")
        Set<Agenda> agendas
) {
}
