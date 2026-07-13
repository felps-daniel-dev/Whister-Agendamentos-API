package br.com.whister.whisteragendamentosapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


public record PacienteRequestDTO(

        @Valid
        PessoaRequestDTO dadosPessoais,

        @NotNull(message = "É necessário o plano o id do plano")
        Long planoId
) {
}
