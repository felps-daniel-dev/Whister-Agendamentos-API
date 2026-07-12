package br.com.whister.whisteragendamentosapi.dto;

public record PacienteResponseDTO(
        PessoaResponseDTO dadosPessoais,
        Long planoId
) {
}
