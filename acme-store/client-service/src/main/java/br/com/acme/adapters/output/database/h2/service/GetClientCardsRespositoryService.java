package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IGetClientCardsDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetClientCardsRespositoryService implements IGetClientCardsDomainRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;
    @Override
    public List<CardDomain> execute(Long id) {
        var entity = this.clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        return (List<CardDomain>) converterDTO
                .convertLIstObjects(entity.getCards(), CardDomain.class);
    }
}
