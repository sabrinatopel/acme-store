package br.com.acme.application.usecase;
import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.IUpdateClientDomainUseCase;
import br.com.acme.application.ports.out.IUpdateClientDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UpdateClientDomainUseCase implements IUpdateClientDomainUseCase {
    
    private final IUpdateClientDomainRepository iUpdateClientDomainRepository;

    @Override
    public ClientDomain execute(Long id, ClientDomain clientDomain){
        return clientDomain.update(id, iUpdateClientDomainRepository);
    }

}
