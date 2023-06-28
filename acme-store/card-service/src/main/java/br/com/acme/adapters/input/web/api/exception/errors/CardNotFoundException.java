package br.com.acme.adapters.input.web.api.exception.errors;

public class CardNotFoundException extends RuntimeException{

    public CardNotFoundException(Long id) {
        super(String.format("Card with %d not found", id));
    }
}
