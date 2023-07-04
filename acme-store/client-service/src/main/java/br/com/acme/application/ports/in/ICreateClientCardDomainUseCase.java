package br.com.acme.application.ports.in;

import br.com.acme.application.domain.entity.CardDomain;
public interface ICreateClientCardDomainUseCase {
    
    CardDomain execute(Long id, CardDomain cardDomain);
}
