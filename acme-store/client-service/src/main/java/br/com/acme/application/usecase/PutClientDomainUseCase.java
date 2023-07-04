package br.com.acme.application.usecase;
import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.IPutClientDomainUseCase;
import br.com.acme.application.ports.out.IPutClientDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PutClientDomainUseCase implements IPutClientDomainUseCase {
    
    private final IPutClientDomainRepository iPutClientDomainRepository;

    @Override
    public ClientDomain execute(Long id, ClientDomain clientDomain){
        return clientDomain.update(id, iPutClientDomainRepository);
    }

}
