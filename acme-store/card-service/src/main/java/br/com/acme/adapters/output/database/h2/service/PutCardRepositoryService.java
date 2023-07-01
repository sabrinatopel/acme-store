package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.input.web.api.exception.errors.CardNotFoundException;
import org.springframework.stereotype.Service;

import br.com.acme.adapters.output.database.h2.entity.Card;
import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IPutCardDomainRepository;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class PutCardRepositoryService implements IPutCardDomainRepository {
    private final CardRepository cardRepository;
    private final ConverterDTO converterDTO;

    @Override
    public CardDomain execute(Long id,CardDomain cardDomain) {
        if (this.cardRepository.findById(id).isEmpty()) {
            throw new CardNotFoundException(id);
        }
        cardDomain.setId(id);
        var entity = (Card) converterDTO.convertObject(cardDomain, Card.class);
        var domain = (CardDomain) converterDTO.convertObject(this.cardRepository.save(entity), CardDomain.class);
        return domain;
    }
}
