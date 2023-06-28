package br.com.acme.adapters.output.database.mysql.service;

import org.springframework.stereotype.Service;

import br.com.acme.adapters.output.database.mysql.entity.Card;
import br.com.acme.adapters.output.database.mysql.repository.CardRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IPutCardDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PutCardRepositoryService implements IPutCardDomainRepository {
    private final CardRepository cardRepository;
    private final ConverterDTO converterDTO;

    @Override
    public CardDomain execute(CardDomain cardDomain) {
        var entity = (Card) converterDTO.convertObject(cardDomain, Card.class);
        var domain = (CardDomain) converterDTO.convertObject(this.cardRepository.save(entity), CardDomain.class);
        return domain;
    }
}
