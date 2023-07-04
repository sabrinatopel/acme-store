package br.com.acme.application.usecase;

import java.util.*;

import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.IDeleteClientCardDomainByIdUseCase;
import br.com.acme.application.ports.out.IDeleteClientCardDomainByIdRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteClientCardDomainByIdUseCase implements IDeleteClientCardDomainByIdUseCase{
    private final IDeleteClientCardDomainByIdRepository iDeleteClientCardDomainByIdRepository;

    @Override
    public void execute(Long id, Long card_id){
        CardDomain card = new CardDomain();
        card.setId(card_id);
        ArrayList<CardDomain> cards = new ArrayList<CardDomain>();
        cards.add(card);
        ClientDomain.builder().id(id).cards(cards).build().deleteClientCardById(iDeleteClientCardDomainByIdRepository);
    }
    
}
