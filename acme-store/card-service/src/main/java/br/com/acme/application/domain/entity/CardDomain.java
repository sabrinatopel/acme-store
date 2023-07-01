package br.com.acme.application.domain.entity;

import lombok.*;
import java.math.BigDecimal;
import java.util.List;
import br.com.acme.application.ports.out.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDomain {
    private Long id;
    private String flag;
    private String number;
    private BigDecimal income;
    private BigDecimal card_limit;

    public CardDomain save(ICreateCardDomainRepository iCreateCardDomainRepository){
        return iCreateCardDomainRepository.execute(this);
    }

    public CardDomain getById(IGetCardDomainByIdRepository iGetCardDomainByIdRepository){
        return iGetCardDomainByIdRepository.execute(this.id);
    }

    public void deleteById(IDeleteCardDomainByIdRepository iDeleteCardDomainByIdRepository){
        iDeleteCardDomainByIdRepository.execute(this.id);
    }

    public List<CardDomain> list(IListCardDomainRepository IListCardDomainRepository){
        return IListCardDomainRepository.execute();
    }

    public CardDomain update(Long id,IPutCardDomainRepository iPutCardDomainRepository){
        return iPutCardDomainRepository.execute(id, this);
    }

    public List<CardDomain> listIncomeLessThanEqual(IListCardDomainIncomeLessThanEqualRepository iListCardDomainIncomeLessThanEqualRepository) {
    return iListCardDomainIncomeLessThanEqualRepository.execute(this.income);
    }
}