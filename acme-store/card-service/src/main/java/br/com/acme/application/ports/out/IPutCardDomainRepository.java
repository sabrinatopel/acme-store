package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.CardDomain;

public interface IPutCardDomainRepository {

    CardDomain execute(Long id,CardDomain cardDomain);
    
}
