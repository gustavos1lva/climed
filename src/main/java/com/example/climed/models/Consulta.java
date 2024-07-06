package com.example.climed.models;

import java.time.Instant;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "consulta")
@Builder
@Getter
@Setter
public final class Consulta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idCon;
    @ManyToOne @JoinColumn(name = "crm") private Medico medico;
    @ManyToOne @JoinColumn(name = "id_esp"/*, referencedColumnName = "id_esp"*/) private Especialidade especialidade;
    @ManyToOne @JoinColumn(name = "id_pac"/*, referencedColumnName = "id_pac"*/) private Paciente paciente;
    private Date data;
    private Instant horaInicCon;
    private Instant horaFimCon;
    private Boolean pagou;
    private Double valorPago;
    private String formaPagamento;
    @OneToOne(mappedBy = "consulta") private Diagnostico diagnostico;

    public Consulta(
            Long idCon,

            Medico medico,

            Especialidade especialidade,

            Paciente paciente,

            Date data,

            Instant horaInicCon,

            Instant horaFimCon,

            Boolean pagou,

            Double valorPago,

            String formaPagamento,

            Diagnostico diagnostico
    ) {
        this.idCon = idCon;
        this.medico = medico;
        this.especialidade = especialidade;
        this.paciente = paciente;
        this.data = data;
        this.horaInicCon = horaInicCon;
        this.horaFimCon = horaFimCon;
        this.pagou = pagou;
        this.valorPago = valorPago;
        this.formaPagamento = formaPagamento;
        this.diagnostico = diagnostico;
    }

    public Consulta() {
        /* empty on purpose */
    }

    @Override
    public String toString() {
        return "Consulta[" +
                "idCon=" + idCon + ", " +
                "medico=" + medico + ", " +
                "especialidade=" + especialidade + ", " +
                "paciente=" + paciente + ", " +
                "data=" + data + ", " +
                "horaInicCon=" + horaInicCon + ", " +
                "horaFimCon=" + horaFimCon + ", " +
                "pagou=" + pagou + ", " +
                "valorPago=" + valorPago + ", " +
                "formaPagamento=" + formaPagamento + ", " +
                "diagnostico=" + diagnostico + ']';
    }

}
