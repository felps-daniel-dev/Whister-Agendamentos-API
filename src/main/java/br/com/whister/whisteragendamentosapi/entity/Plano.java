package br.com.whister.whisteragendamentosapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int qtd_consultas_gratis_trimestral;

    @Column(nullable = false)
    private Double desconto;

    @Column(name = "data_ultimo_reset", nullable = false)
    private LocalDate dataUltimoReset;

}
