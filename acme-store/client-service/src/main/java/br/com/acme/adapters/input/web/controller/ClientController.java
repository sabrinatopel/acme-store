package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.ClientApi;
import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.acme.adapters.input.web.api.request.CardRequest;
import br.com.acme.adapters.input.web.api.request.ClientRequest;
import br.com.acme.adapters.input.web.api.response.CardResponse;
import br.com.acme.adapters.input.web.api.response.ClientResponse;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.*;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClientController implements ClientApi {
    private final ICreateClientDomainUseCase iCreateClientDomainUseCase;
    private final IListClientDomainUseCase iListClientDomainUseCase;
    private final IGetClientDomainByIdUseCase iGetClientDomainGetByIdUseCase;
    private final IGetClientCardsDomainUseCase iGetClientCardsDomainUseCase;
    private final IDeleteClientDomainByIdUseCase iDeleteClientDomainByIdUseCase;
    private final IPutClientDomainUseCase iPutClientDomainUseCase;
    private final ICreateClientCardDomainUseCase iCreateClientCardDomainUseCase;
    private final IDeleteClientCardDomainByIdUseCase iDeleteClientCardDomainByIdUseCase;
    private final IGetClientCardDomainByIdUseCase iGetClientCardDomainByIdUseCase;

    private final ConverterDTO converterDTO;

    @Override
    public ResponseEntity<ClientResponse> create(ClientRequest clientRequest) {
        var domain = (ClientDomain) converterDTO.convertObject(clientRequest, ClientDomain.class);
        var response = this.iCreateClientDomainUseCase.execute(domain);
        return ResponseEntity.ok((ClientResponse) converterDTO.convertObject(response, ClientResponse.class));
    }

    @Override
    public ResponseEntity<List<ClientResponse>> list() {
        var response = (List<ClientResponse>) converterDTO.convertLIstObjects(this.iListClientDomainUseCase.execute(),
                ClientResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ClientResponse> get(Long id) {
        try {
            var domain = (ClientDomain) this.iGetClientDomainGetByIdUseCase.execute(id);
            return ResponseEntity.ok((ClientResponse) converterDTO
                    .convertObject(domain, ClientResponse.class));
        } catch (ClientNotFoundException e) {
            throw new ClientNotFoundException(id);
        }
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        this.iDeleteClientDomainByIdUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ClientResponse> update(Long id, ClientRequest clientRequest) {
        try {
            var domain = (ClientDomain) converterDTO.convertObject(clientRequest, ClientDomain.class);
            var response = this.iPutClientDomainUseCase.execute(id, domain);
            return ResponseEntity.ok((ClientResponse) converterDTO.convertObject(response, ClientResponse.class));
        } catch (ClientNotFoundException e) {
            throw new ClientNotFoundException(id);
        }
    }

    @Override
    public ResponseEntity<List<CardResponse>> getClientCards(Long id) {
        try {

            var response = (List<CardResponse>) converterDTO
                    .convertLIstObjects(this.iGetClientCardsDomainUseCase.execute(id), CardResponse.class);
            return ResponseEntity.ok(response);
        } catch (ClientNotFoundException e) {
            throw new ClientNotFoundException(id);
        }

    }

    @Override
    public ResponseEntity<CardResponse> createClientCard(Long id, CardRequest cardRequest) {
        var domain = (CardDomain) converterDTO.convertObject(cardRequest, CardDomain.class);
        var response = (CardResponse) converterDTO
                        .convertObject(this.iCreateClientCardDomainUseCase.execute(id, domain), CardResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> deleteClientCard(Long id, Long card_id){
        iDeleteClientCardDomainByIdUseCase.execute(id, card_id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<CardResponse> getClientCard(Long id, Long card_id){
        var response = iGetClientCardDomainByIdUseCase.execute(id, card_id);
        return ResponseEntity.ok((CardResponse) converterDTO
                    .convertObject(response, CardResponse.class));
    }
}
