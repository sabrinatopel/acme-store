package br.com.acme.application.usecase;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.IUpdateClientCardDomainUseCase;
import br.com.acme.application.ports.out.IUpdateClientCardDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateClientCardDomainUseCase implements IUpdateClientCardDomainUseCase {
    private final IUpdateClientCardDomainRepository iUpdateClientCardDomainRepository;

    @Override
    public CardDomain execute(Long id, Long card_id, CardDomain cardDomain){
        cardDomain.setId(card_id);
        ArrayList<CardDomain> cards = new ArrayList<CardDomain>();
        cards.add(cardDomain);
        return ClientDomain.builder().id(id).cards(cards).build().updateClientCard(iUpdateClientCardDomainRepository);
    }
    
    
}
