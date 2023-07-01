package br.com.acme.adapters.input.web.controller;

import br.com.acme.adapters.input.web.api.ClientApi;
import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.acme.adapters.input.web.api.request.ClientRequest;
import br.com.acme.adapters.input.web.api.response.ClientResponse;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.in.ICreateClientDomainUseCase;
import br.com.acme.application.ports.in.IDeleteClientDomainByIdUseCase;
import br.com.acme.application.ports.in.IGetClientDomainByIdUseCase;
import br.com.acme.application.ports.in.IListClientDomainUseCase;
import br.com.acme.application.ports.in.IPutClientDomainUseCase;
import lombok.AllArgsConstructor;
import org.junit.platform.commons.function.Try;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ClientController implements ClientApi {
    private final ICreateClientDomainUseCase iCreateClientDomainUseCase;
    private final IListClientDomainUseCase iListClientDomainUseCase;
    private final IGetClientDomainByIdUseCase iGetClientDomainGetByIdUseCase;
    private final IDeleteClientDomainByIdUseCase iDeleteClientDomainByIdUseCase;
    private final IPutClientDomainUseCase iPutClientDomainUseCase ;

    private final ConverterDTO converterDTO;
    @Override
    public ResponseEntity<ClientResponse> create(ClientRequest clientRequest) {
            var domain = (ClientDomain) converterDTO.convertObject(clientRequest, ClientDomain.class);
            var response = this.iCreateClientDomainUseCase.execute(domain);
            return ResponseEntity.ok((ClientResponse) converterDTO.convertObject(response, ClientResponse.class));
    }

    @Override
    public ResponseEntity<List<ClientResponse>> list() {
        var response = (List<ClientResponse>)
                converterDTO.convertLIstObjects(this.iListClientDomainUseCase.execute(), ClientResponse.class);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ClientResponse> get(Long id){
        try {
            var domain = (ClientDomain) this.iGetClientDomainGetByIdUseCase.execute(id);
            return ResponseEntity.ok((ClientResponse) converterDTO
                    .convertObject(domain, ClientResponse.class));
        }catch (ClientNotFoundException e) {
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
            try{
            var domain = (ClientDomain) converterDTO.convertObject(clientRequest, ClientDomain.class);
           // domain.setId(id);
            var response = this.iPutClientDomainUseCase.execute(id, domain);
            return ResponseEntity.ok((ClientResponse) converterDTO.convertObject(response, ClientResponse.class));
            }catch(ClientNotFoundException e){
                throw new ClientNotFoundException(id);
            }
    }
}
