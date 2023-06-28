package br.com.acme.application.usecase;

import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.IGetClientDomainByIdUseCase;
import br.com.acme.application.ports.out.IGetClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetClientDomainByIdUseCase implements IGetClientDomainByIdUseCase {

    private final IGetClientDomainByIdRepository iGetClientDomainGetByIdRepository;
    @Override
    public ClientDomain execute(Long id) {
        return ClientDomain.builder()
                .id(id)
                .build().getById(iGetClientDomainGetByIdRepository);
    }
}
