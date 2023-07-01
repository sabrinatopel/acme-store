package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.ports.in.IListCardDomainIncomeLessThanEqualUseCase;
import br.com.acme.application.ports.out.IListCardDomainIncomeLessThanEqualRepository;
import br.com.acme.application.ports.out.IListCardDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ListCardDomainIncomeLessThanEqualUseCase implements IListCardDomainIncomeLessThanEqualUseCase {
    private final IListCardDomainIncomeLessThanEqualRepository iListCardDomainIncomeLessThanEqualRepository;

    @Override
    public List<CardDomain> execute(BigDecimal income){
        return CardDomain.builder().income(income).build().listIncomeLessThanEqual(iListCardDomainIncomeLessThanEqualRepository);
    }
}
