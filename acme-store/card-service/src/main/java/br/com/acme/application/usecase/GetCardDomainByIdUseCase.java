package br.com.acme.application.usecase;

import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.IGetCardDomainByIdUseCase;
import br.com.acme.application.ports.out.IGetCardDomainByIdRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetCardDomainByIdUseCase implements IGetCardDomainByIdUseCase{
    
    private final IGetCardDomainByIdRepository iGetCardDomainByIdRepository;

    @Override
    public CardDomain execute(Long id){
        return CardDomain.builder().id(id).build().getById(iGetCardDomainByIdRepository);
    }
}
