package br.com.acme.application.ports.out;

import java.util.List;

import br.com.acme.application.domain.entity.CardDomain;

public interface ICreateClientCardDomainRepository {

    CardDomain execute(Long id, CardDomain cardDomain);
}
