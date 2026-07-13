package br.com.whister.whisteragendamentosapi.exception;

import br.com.whister.whisteragendamentosapi.exception.custom.PacienteNaoEncontrado;
import br.com.whister.whisteragendamentosapi.exception.dto.ApiErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(PacienteNaoEncontrado.class)
    public ResponseEntity<ApiErrorResponseDTO> handlePacienteNaoEncontrado(
            PacienteNaoEncontrado ex,
            HttpServletRequest request
    ){
        return buildErrorResponse(
                HttpStatus.NOT_FOUND,
                "Recurso não encontrado!",
                ex.getMessage(),
                request.getRequestURI()
        );
    }





    private ResponseEntity<ApiErrorResponseDTO> buildErrorResponse(
            HttpStatus status,
            String error,
            String message,
            String path
    ) {
        ApiErrorResponseDTO erroResponse = new ApiErrorResponseDTO(
                LocalDateTime.now(),
                status.value(),
                error,
                message,
                path
        );
        return ResponseEntity.status(status).body(erroResponse);
    }
}
