package br.com.acme.application.ports.in;

import br.com.acme.application.domain.entity.CardDomain;
import java.util.List;
public interface ICreateClientCardDomainUseCase {
    
    CardDomain execute(Long id, CardDomain cardDomain);
}
