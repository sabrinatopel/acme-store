package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IGetClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetClientDomainByIdRepositoryService implements IGetClientDomainByIdRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public ClientDomain execute(Long id) {
        var entity = this.clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        return (ClientDomain) converterDTO
                .convertObject(entity, ClientDomain.class);
    }
}
