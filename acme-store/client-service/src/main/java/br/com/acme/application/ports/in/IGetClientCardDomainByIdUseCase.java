package br.com.acme.application.ports.in;

import br.com.acme.application.domain.entity.CardDomain;

public interface IGetClientCardDomainByIdUseCase {
    CardDomain execute(Long id, Long card_id);
}
