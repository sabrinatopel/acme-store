package br.com.acme.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import br.com.acme.application.ports.out.ICreateCardDomainRepository;
import br.com.acme.application.ports.out.IDeleteCardDomainByIdRepository;
import br.com.acme.application.ports.out.IGetCardDomainByIdRepository;
import br.com.acme.application.ports.out.IListCardDomainRepository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDomain {
    private Long id;
    private String flag;
    private String number;
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
}