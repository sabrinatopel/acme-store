package br.com.acme.adapters.input.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.com.acme.adapters.input.web.api.CardApi;
import br.com.acme.adapters.input.web.api.request.CardRequest;
import br.com.acme.adapters.input.web.api.response.CardResponse;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.ICreateCardDomainUseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CardController implements CardApi{
    private final ICreateCardDomainUseCase iCreateCardDomainUseCase;

    private final ConverterDTO converterDTO;

    @Override
    public ResponseEntity<CardResponse> create(CardRequest cardRequest){
        var domain = (CardDomain) converterDTO.convertObject(cardRequest, CardDomain.class);
        var response = this.iCreateCardDomainUseCase.execute(domain);
        return ResponseEntity.ok((CardResponse) converterDTO.convertObject(response, CardResponse.class));
    }

}
