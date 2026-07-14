package br.com.whister.whisteragendamentosapi.dto;

public record PacienteResponseDTO(
        Long id,
        PessoaResponseDTO dadosPessoais,
        Long planoId,
        boolean ativo
) {
}
