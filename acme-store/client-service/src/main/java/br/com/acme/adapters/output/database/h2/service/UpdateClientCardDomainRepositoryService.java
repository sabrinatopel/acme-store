package br.com.acme.adapters.output.database.h2.service;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import br.com.acme.adapters.input.web.api.exception.errors.ClientCardNotFoundException;
import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.acme.adapters.output.database.h2.entity.Card;
import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IUpdateClientCardDomainRepository;
import lombok.AllArgsConstructor;
import java.util.List;

@Service
@AllArgsConstructor
public class UpdateClientCardDomainRepositoryService implements IUpdateClientCardDomainRepository {

    private final ClientRepository clientRepository;
    private final ConverterDTO converterDTO;

    @Override
    public CardDomain execute(Long id, Long card_id, CardDomain cardDomain) {
        var entity = this.clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        List<Card> cards = entity.getCards();
        Optional<Card> optionalCard = cards.stream()
                .filter(card -> card.getId().equals(card_id))
                .findFirst();

        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();
            card.setCard_limit(cardDomain.getCard_limit());
            card.setIncome(cardDomain.getIncome());
            card.setNumber(cardDomain.getNumber());
            card.setFlag(cardDomain.getFlag());
        } else {
            throw new ClientCardNotFoundException(card_id);
        }

        entity.setCards(cards);
        var savedEntity = this.clientRepository.save(entity);

        Card updatedCard = savedEntity.getCards().stream()
                .filter(card -> card.getId().equals(card_id))
                .findFirst()
                .orElseThrow(() -> new ClientCardNotFoundException(card_id));

        return (CardDomain) converterDTO.convertObject(updatedCard, CardDomain.class);
    }

}
