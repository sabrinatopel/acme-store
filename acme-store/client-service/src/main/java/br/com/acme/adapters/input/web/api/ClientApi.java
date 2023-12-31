package br.com.acme.adapters.input.web.api;

import br.com.acme.adapters.input.web.api.request.CardRequest;
import br.com.acme.adapters.input.web.api.request.ClientRequest;
import br.com.acme.adapters.input.web.api.response.CardResponse;
import br.com.acme.adapters.input.web.api.response.ClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/clients")
public interface ClientApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ClientResponse> create(@RequestBody ClientRequest clientRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ClientResponse>> list();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<ClientResponse> get(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> delete(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ClientResponse> update(@PathVariable("id") Long id, @RequestBody ClientRequest clientRequest);

    @GetMapping("/{id}/cards")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<CardResponse>> getClientCards(@PathVariable("id") Long id);

    @PostMapping("/{id}/cards")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CardResponse> createClientCard(@PathVariable("id") Long id, @RequestBody CardRequest cardRequest);

    @DeleteMapping("/{id}/cards/{card_id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> deleteClientCard(@PathVariable("id") Long id, @PathVariable("card_id") Long card_id);

    @GetMapping("/{id}/cards/{card_id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CardResponse> getClientCard(@PathVariable("id") Long id, @PathVariable("card_id") Long card_id);

    @PutMapping("/{id}/cards/{card_id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CardResponse> updateClientCard(@PathVariable("id") Long id, @PathVariable("card_id") Long card_id, @RequestBody CardRequest cardRequest);
}
