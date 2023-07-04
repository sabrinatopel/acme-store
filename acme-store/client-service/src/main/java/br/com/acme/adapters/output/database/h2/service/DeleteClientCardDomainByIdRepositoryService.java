package br.com.acme.adapters.output.database.h2.service;

import org.springframework.stereotype.Service;

import br.com.acme.adapters.input.web.api.exception.errors.*;
import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.ports.out.IDeleteClientCardDomainByIdRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteClientCardDomainByIdRepositoryService implements IDeleteClientCardDomainByIdRepository {
    private final ClientRepository clientRepository;

    @Override
    public void execute(Long id, Long card_id) {
       var client = this.clientRepository.findById(id)
        .orElseThrow(() -> new ClientNotFoundException(id));
       
        var cards = client.getCards();

        
        if (!cards.stream().anyMatch(card -> card.getId().equals(card_id))) {
            throw new ClientCardNotFoundException(card_id);
        }
        cards.removeIf(card -> card.getId().equals(card_id));
        this.clientRepository.save(client);

    }
}
