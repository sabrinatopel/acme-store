package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.acme.adapters.output.database.h2.entity.Card;
import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.ICreateClientCardDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateClientCardRepositoryService implements ICreateClientCardDomainRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public CardDomain execute(Long id, CardDomain cardDomain) {
        var entity = this.clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        var card = converterDTO.convertObject(cardDomain, Card.class);
        var cards = entity.getCards();
        cards.add((Card) card);

        entity.setCards(cards);
        var savedEntity = this.clientRepository.save(entity);
        var lastCard = savedEntity.getCards().get(savedEntity.getCards().size() - 1);

        return (CardDomain) converterDTO.convertObject(lastCard, CardDomain.class);
    }

}
