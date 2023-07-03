package br.com.acme.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.domain.entity.ClientDomain;
import br.com.acme.application.ports.in.IGetClientCardsDomainUseCase;
import br.com.acme.application.ports.out.IGetClientCardsDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetClientCardsDomainUseCase implements IGetClientCardsDomainUseCase {

    private final IGetClientCardsDomainRepository iGetClientCardsDomainRepository;

    @Override
    public List<CardDomain> execute(Long id) {
        return ClientDomain.builder()
                .id(id)
                .build().getCards(iGetClientCardsDomainRepository);
    }
}
