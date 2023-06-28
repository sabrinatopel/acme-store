package br.com.acme.application.ports.in;

import br.com.acme.application.domain.entity.ClientDomain;

public interface IGetClientDomainByIdUseCase {
    ClientDomain execute(Long id);
}
