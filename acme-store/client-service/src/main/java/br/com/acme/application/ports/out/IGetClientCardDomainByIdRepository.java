package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.CardDomain;

public interface IGetClientCardDomainByIdRepository {
    CardDomain execute(Long id, Long card_id);
}
