package br.com.acme.application.usecase;

import java.util.*;

import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.ICreateClientCardDomainUseCase;
import br.com.acme.application.ports.out.ICreateClientCardDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateClientCardDomainUseCase implements ICreateClientCardDomainUseCase {

    private final ICreateClientCardDomainRepository iCreateClientCardDomainRepository;

    @Override
    public List<CardDomain> execute(Long id, CardDomain cardDomain) {
        ArrayList<CardDomain> cards = new ArrayList<CardDomain>();
        cards.add(cardDomain);
        return ClientDomain.builder()
                .id(id)
                .cards(cards)
                .build().createClientCard(iCreateClientCardDomainRepository);
    }
}
