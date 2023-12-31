package br.com.acme.adapters.input.web.api;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.acme.adapters.input.web.api.request.CardRequest;
import br.com.acme.adapters.input.web.api.response.CardResponse;

@RequestMapping("/api/v1/cards")
public interface CardApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CardResponse> create(@RequestBody CardRequest cardRequest);
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CardResponse> get(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<?> deleteById(@PathVariable("id") Long id);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<CardResponse>> list();

    @GetMapping("/income/{income}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<CardResponse>> listIncomeLessThanEqual(@PathVariable("income")BigDecimal income);

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<CardResponse> update(@PathVariable("id") Long id, @RequestBody CardRequest cardRequest);
}
