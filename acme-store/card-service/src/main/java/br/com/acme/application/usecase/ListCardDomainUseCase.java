package br.com.acme.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.IListCardDomainUseCase;
import br.com.acme.application.ports.out.IListCardDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListCardDomainUseCase implements IListCardDomainUseCase {
    
    private final IListCardDomainRepository iListCardDomainRepository;

    @Override
    public List<CardDomain> execute(){
        return CardDomain.builder().build().list(iListCardDomainRepository);
    }
}
