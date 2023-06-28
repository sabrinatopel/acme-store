package br.com.acme.adapters.output.database.h2.service;

import org.springframework.stereotype.Service;

import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.acme.adapters.output.database.h2.entity.Client;
import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IPutClientDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PutClientRepositoryService implements IPutClientDomainRepository {
    
    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public ClientDomain execute(ClientDomain clientDomain){
    var entity = (Client) converterDTO.convertObject(clientDomain, Client.class);
        var domain = (ClientDomain) converterDTO.convertObject(this.clientRepository.save(entity), ClientDomain.class);

        return domain;
    }
}
