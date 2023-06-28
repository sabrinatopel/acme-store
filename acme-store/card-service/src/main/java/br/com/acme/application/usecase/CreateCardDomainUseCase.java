package br.com.acme.application.usecase;

import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.ICreateCardDomainUseCase;
import br.com.acme.application.ports.out.ICreateCardDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreateCardDomainUseCase implements ICreateCardDomainUseCase{
    private final ICreateCardDomainRepository iCreateCardDomainRepository;

    @Override
    public CardDomain execute(CardDomain cardDomain){
        return cardDomain.save(iCreateCardDomainRepository);
    }
    
}
