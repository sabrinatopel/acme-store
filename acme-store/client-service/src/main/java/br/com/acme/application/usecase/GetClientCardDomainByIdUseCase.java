package br.com.acme.application.usecase;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.IGetClientCardDomainByIdUseCase;
import br.com.acme.application.ports.out.IGetClientCardDomainByIdRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetClientCardDomainByIdUseCase implements IGetClientCardDomainByIdUseCase {
   private final IGetClientCardDomainByIdRepository iGetClientCardDomainByIdRepository;

    @Override
    public CardDomain execute(Long id, Long card_id){
        CardDomain card = new CardDomain();
        card.setId(card_id);
        ArrayList<CardDomain> cards = new ArrayList<CardDomain>();
        cards.add(card);
        return ClientDomain.builder().id(id).cards(cards).build().getClientCardById(iGetClientCardDomainByIdRepository);
    }
    
}
