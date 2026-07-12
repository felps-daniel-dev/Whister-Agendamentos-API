package br.com.whister.whisteragendamentosapi.entity;

import br.com.whister.whisteragendamentosapi.entity.enums.StatusConsulta;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @OneToOne
    private Sala sala;

    @Column(name = "data_hora", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataHora;

    @Column(name = "valor_bruto", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorBruto;

    @Column(name = "valor_descontos", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorDescontos;

    @Column(name = "valor_final", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorFinal;

    @Column(name = "motivo_previo")
    private String motivoPrevio;

    @Column(nullable = false)
    private boolean especial = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusConsulta status;

    @Column(name = "motivo_cancelamento")
    private String motivoCancelamento;

    @Column(name = "criado_em", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate criadoEm;

    @Column(name = "atualizado_em", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate atualizadoEm;


}
