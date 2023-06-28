package br.com.acme.application.usecase;

import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.IDeleteCardDomainByIdUseCase;
import br.com.acme.application.ports.out.IDeleteCardDomainByIdRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteCardDomainByIdUseCase implements IDeleteCardDomainByIdUseCase{
    private final IDeleteCardDomainByIdRepository iDeleteCardDomainByIdRepository;

    @Override
    public void execute(Long id){
       CardDomain.builder().id(id).build().deleteById(iDeleteCardDomainByIdRepository);
    }
}
