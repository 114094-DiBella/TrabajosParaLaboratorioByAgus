package ar.edu.utn.frc.tup.lciii.proyectoconspringn1.controllers;

import ar.edu.utn.frc.tup.lciii.proyectoconspringn1.dtos.common.ErrorApi;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

/**
 * Clase para manejar excepciones globales en los controladores.
 * Anotada con @ControllerAdvice para ser detectada por Spring.
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Maneja excepciones generales del tipo Exception.
     * Devuelve una respuesta HTTP 500 Internal Server Error.
     *
     * @param exception la excepción capturada
     * @return ResponseEntity con el objeto ErrorApi y el código de estado HTTP 500
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApi> handleError(Exception exception){
        ErrorApi errorApi = buildError(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorApi);
    }

    /**
     * Maneja excepciones de validación de argumentos no válidos (MethodArgumentNotValidException).
     * Devuelve una respuesta HTTP 400 Bad Request.
     *
     * @param exception la excepción capturada
     * @return ResponseEntity con el objeto ErrorApi y el código de estado HTTP 400
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorApi> handleError(MethodArgumentNotValidException exception){
        ErrorApi errorApi = buildError(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorApi);
    }

    /**
     * Maneja excepciones de tipo ResponseStatusException.
     * Utiliza el código de estado y la razón proporcionada en la excepción.
     *
     * @param exception la excepción capturada
     * @return ResponseEntity con el objeto ErrorApi y el código de estado HTTP correspondiente
     */
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ErrorApi> handleError(ResponseStatusException exception){
        ErrorApi errorApi = buildError(exception.getReason(), HttpStatus.valueOf(exception.getStatusCode().value()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorApi);
    }

    /**
     * Maneja excepciones de tipo EntityNotFoundException.
     * Devuelve una respuesta HTTP 404 Not Found.
     *
     * @param exception la excepción capturada
     * @return ResponseEntity con el objeto ErrorApi y el código de estado HTTP 404
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorApi> handleError(EntityNotFoundException exception){
        ErrorApi errorApi = buildError(exception.getMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorApi);
    }

    /**
     * Construye un objeto ErrorApi a partir del mensaje de error y el código de estado HTTP.
     *
     * @param message el mensaje de error
     * @param httpStatus el código de estado HTTP
     * @return un nuevo objeto ErrorApi configurado
     */
    private ErrorApi buildError(String message, HttpStatus httpStatus) {
        return ErrorApi.builder()
                .timestamp(String.valueOf(Timestamp.from(ZonedDateTime.now().toInstant())))
                .error(httpStatus.getReasonPhrase())
                .message(message)
                .build();
    }
}

