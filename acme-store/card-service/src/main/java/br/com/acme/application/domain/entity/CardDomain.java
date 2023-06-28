package br.com.acme.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

import br.com.acme.application.ports.out.ICreateCardDomainRepository;

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
}