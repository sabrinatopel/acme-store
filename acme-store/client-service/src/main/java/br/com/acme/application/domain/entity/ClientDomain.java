package br.com.acme.application.domain.entity;
import br.com.acme.application.ports.out.*;
import lombok.*;

import java.math.BigDecimal;
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
    private BigDecimal income;
    private List<CardDomain> cards;

    public ClientDomain save(ICreateClientDomainRepository iCreateClientDomainRepository) {
        return iCreateClientDomainRepository.execute(this);
    }

    public List<ClientDomain> list(IListClientDomainRepository iListClientDomainRepository) {
        return iListClientDomainRepository.execute();
    }

    public ClientDomain getById(IGetClientDomainByIdRepository iGetClientDomainByIdRepository) {
        return iGetClientDomainByIdRepository.execute(this.id);
    }

    public void deleteClientDomain(IDeleteClientDomainByIdRepository iDeleteClientDomainByIdRepository) {
        iDeleteClientDomainByIdRepository.execute(this.id);
    }

    public ClientDomain update(Long id, IPutClientDomainRepository iUpdateClientDomainRepository) {
        return iUpdateClientDomainRepository.execute(id, this);
    }

    public List<CardDomain> getCards(IGetClientCardsDomainRepository iGetClientDomainByIdRepository) {
        return iGetClientDomainByIdRepository.execute(this.id);
    }

    public CardDomain createClientCard(ICreateClientCardDomainRepository iCreateClientCardDomainRepository) {
        return iCreateClientCardDomainRepository.execute(this.id, this.cards.get(0));
    }

    public void deleteClientCardById(IDeleteClientCardDomainByIdRepository iDeleteClientCardDomainByIdRepository) {
        iDeleteClientCardDomainByIdRepository.execute(this.id, this.cards.get(0).getId());
    }

    public CardDomain getClientCardById(IGetClientCardDomainByIdRepository iGetClientCardDomainByIdRepository) {
        return iGetClientCardDomainByIdRepository.execute(this.id, this.cards.get(0).getId());
    }

    public CardDomain updateClientCard(IUpdateClientCardDomainRepository iUpdateClientCardDomainRepository) {
        return iUpdateClientCardDomainRepository.execute(this.id, this.cards.get(0).getId(), this.cards.get(0));
    }

}
