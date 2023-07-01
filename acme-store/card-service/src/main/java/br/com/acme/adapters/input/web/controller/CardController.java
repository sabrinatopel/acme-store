package br.com.acme.adapters.input.web.controller;

import java.util.List;

import br.com.acme.application.ports.in.*;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.adapters.input.web.api.CardApi;
import br.com.acme.adapters.input.web.api.exception.errors.CardNotFoundException;
import br.com.acme.adapters.input.web.api.request.CardRequest;
import br.com.acme.adapters.input.web.api.response.CardResponse;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CardController implements CardApi {
    private final ICreateCardDomainUseCase iCreateCardDomainUseCase;
    private final IPutCardDomainUseCase iPutCardDomainUseCase;
    private final IGetCardDomainByIdUseCase iGetCardDomainByIdUseCase;
    private final IDeleteCardDomainByIdUseCase iDeleteCardDomainByIdUseCase;
    private final IListCardDomainUseCase iListCardDomainUseCase;

    private final ConverterDTO converterDTO;

    @Override
    public ResponseEntity<CardResponse> create(CardRequest cardRequest) {
        var domain = (CardDomain) converterDTO.convertObject(cardRequest, CardDomain.class);
        var response = this.iCreateCardDomainUseCase.execute(domain);
        return ResponseEntity.ok((CardResponse) converterDTO.convertObject(response, CardResponse.class));
    }

    @Override
    public ResponseEntity<CardResponse> get(Long id) {
        try {
            var domain = (CardDomain) this.iGetCardDomainByIdUseCase.execute(id);
            return ResponseEntity.ok((CardResponse) converterDTO
                    .convertObject(domain, CardResponse.class));
        } catch (CardNotFoundException e) {
            throw new CardNotFoundException(id);
        }
    }

    @Override
    public ResponseEntity<?> deleteById(Long id) {
        this.iDeleteCardDomainByIdUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CardResponse> update(Long id, CardRequest cardRequest) {
        try {
            var domain = (CardDomain) converterDTO.convertObject(cardRequest, CardDomain.class);
            var response = this.iPutCardDomainUseCase.execute(id, domain);
            return ResponseEntity.ok((CardResponse) converterDTO.convertObject(response, CardResponse.class));
        } catch (CardNotFoundException e) {
            throw new CardNotFoundException(id);
        }
    }

    @Override
    public ResponseEntity<List<CardResponse>> list() {
        var list = converterDTO.convertListObjects(this.iListCardDomainUseCase.execute(), CardResponse.class);
        return ResponseEntity.ok(list);
    }

}
