package br.com.acme.adapters.input.web.api.exception.errors;

public class ClientCardNotFoundException extends RuntimeException{

    public ClientCardNotFoundException(Long id) {
        super(String.format("Client Card with %d not found", id));
    }
}
