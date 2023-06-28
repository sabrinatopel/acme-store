package br.com.acme.adapters.output.database.mysql.service;

import org.springframework.stereotype.Service;

import br.com.acme.adapters.input.web.api.exception.errors.CardNotFoundException;
import br.com.acme.adapters.output.database.mysql.repository.CardRepository;
import br.com.acme.application.domain.entity.CardDomain;
import br.com.acme.application.mapper.ConverterDTO;
import br.com.acme.application.ports.out.IGetCardDomainByIdRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GetCardByIdRepositoryService implements IGetCardDomainByIdRepository{
    private final CardRepository cardRepository;
    private final ConverterDTO converterDTO;

    @Override
    public final CardDomain execute(Long id){
        var entity = this.cardRepository.findById(id);
        if(entity.isEmpty()){
            throw new CardNotFoundException(id);
        }
        return (CardDomain) converterDTO.convertObject(entity, CardDomain.class);
    }
    
}
