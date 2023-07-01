package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.CardDomain;

import java.math.BigDecimal;
import java.util.List;

public interface IListCardDomainIncomeLessThanEqualRepository {
    List<CardDomain> execute(BigDecimal income);
}
