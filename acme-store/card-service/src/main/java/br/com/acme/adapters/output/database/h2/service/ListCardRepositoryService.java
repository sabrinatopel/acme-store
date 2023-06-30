package br.com.acme.adapters.output.database.h2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.acme.adapters.output.database.h2.repository.CardRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IListCardDomainRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListCardRepositoryService implements IListCardDomainRepository {
    
    private final CardRepository cardRepository;
    private final ConverterDTO converterDTO;

    @Override
    public List<CardDomain> execute(){
        return (List<CardDomain>) converterDTO
                .convertListObjects(this.cardRepository.findAll(), CardDomain.class);
    }
}
