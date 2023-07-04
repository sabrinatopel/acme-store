package br.com.acme.adapters.output.database.h2.service;

import org.springframework.stereotype.Service;

import br.com.acme.adapters.input.web.api.exception.errors.CardNotFoundException;
import br.com.acme.adapters.input.web.api.exception.errors.ClientCardNotFoundException;
import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IGetClientCardDomainByIdRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetClientCardDomainByIdService implements IGetClientCardDomainByIdRepository{

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public CardDomain execute(Long id, Long card_id) {
        var entity = this.clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        var cardEntity = entity.getCards().stream()
                .filter(card -> card.getId().equals(card_id))
                .findFirst()
                .orElseThrow(() -> new ClientCardNotFoundException(card_id));

        return (CardDomain) converterDTO.convertObject(cardEntity, CardDomain.class);
    }
}
