package br.com.acme.application.ports.out;

import br.com.acme.application.domain.entity.ClientDomain;

public interface IGetClientDomainByIdRepository {

    ClientDomain execute(Long id);
}
