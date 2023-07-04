package br.com.acme.adapters.input.web.api.exception;

import br.com.acme.adapters.input.web.api.exception.errors.ApiErrorsResponse;
import br.com.acme.adapters.input.web.api.exception.errors.ClientCardNotFoundException;
import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ApiErrorsResponse> handleClientNotFoundException(
            ClientNotFoundException exception, WebRequest webRequest
    ) {
        var dataError = ApiErrorsResponse.DataMessageError
                .builder()
                .description("client not found")
                .dateTime(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message("Client search not found")
                .build();

        var apiError = ApiErrorsResponse.builder()
                .dataMessageError(dataError)
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<ApiErrorsResponse>(apiError, HttpStatus.NOT_FOUND);
    }

        @ExceptionHandler(ClientCardNotFoundException.class)
    public ResponseEntity<ApiErrorsResponse> handleClientCardNotFoundException(
            ClientCardNotFoundException exception, WebRequest webRequest
    ) {
        var dataError = ApiErrorsResponse.DataMessageError
                .builder()
                .description("client card not found")
                .dateTime(LocalDateTime.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .message("Client card search not found")
                .build();

        var apiError = ApiErrorsResponse.builder()
                .dataMessageError(dataError)
                .status(HttpStatus.NOT_FOUND)
                .build();

        return new ResponseEntity<ApiErrorsResponse>(apiError, HttpStatus.NOT_FOUND);
    }
}
