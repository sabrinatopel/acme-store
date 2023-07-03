package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.acme.adapters.output.database.h2.entity.Card;
import br.com.acme.adapters.output.database.h2.entity.Client;
import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.ICreateClientCardDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CreateClientCardRepositoryService implements ICreateClientCardDomainRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;
    @Override
    public List<CardDomain> execute(Long id, CardDomain cardDomain) {
        var entity = this.clientRepository.findById(id);
        if (entity.isEmpty()) {
            throw new ClientNotFoundException(id);
        } 
        var card = converterDTO.convertObject(cardDomain, Card.class);
        List<Card> cards =  entity.get().getCards();
        cards.add((Card) card);
        entity.get().setCards(cards);
        this.clientRepository.save(entity.get());

        return (List<CardDomain>) converterDTO
                .convertLIstObjects(entity.get().getCards(), CardDomain.class);
    }
}
