package br.com.whister.whisteragendamentosapi.exception;

import java.time.LocalDateTime;

public record ApiErrorResponseDTO(
        LocalDateTime timestap,
        Integer status,
        String error,
        String message,
        String path
) {
}
