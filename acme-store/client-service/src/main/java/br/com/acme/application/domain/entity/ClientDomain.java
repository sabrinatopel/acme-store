package br.com.acme.application.domain.entity;
import br.com.acme.application.ports.out.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDomain {
    private Long id;
    private String name;
    private String email;
    private String document;
    private String phone;

    public ClientDomain save(ICreateClientDomainRepository iCreateClientDomainRepository){
        return iCreateClientDomainRepository.execute(this);
    }

    public List<ClientDomain> list(IListClientDomainRepository iListClientDomainRepository){
        return iListClientDomainRepository.execute();
    }

    public ClientDomain getById(IGetClientDomainByIdRepository iGetClientDomainByIdRepository) {
        return iGetClientDomainByIdRepository.execute(this.id);
    }

    public void deleteClientDomain(IDeleteClientDomainByIdRepository iDeleteClientDomainByIdRepository) {
        iDeleteClientDomainByIdRepository.execute(this.id);
    }

    public ClientDomain update(IPutClientDomainRepository iPutClientDomainRepository){
        return iPutClientDomainRepository.execute(this);
    }

}
