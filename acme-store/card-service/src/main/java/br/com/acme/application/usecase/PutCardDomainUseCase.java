package br.com.acme.application.usecase;

import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.IPutCardDomainUseCase;
import br.com.acme.application.ports.out.IPutCardDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PutCardDomainUseCase implements IPutCardDomainUseCase {
    private final IPutCardDomainRepository iPutCardDomainRepository;

    @Override
    public CardDomain execute(Long id, CardDomain cardDomain){
        return cardDomain.update(id,iPutCardDomainRepository);
    }
}
