package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.CardDomain;

public interface IUpdateClientCardDomainRepository {
    CardDomain execute(Long id, Long card_id, CardDomain cardDomain);
}
