package br.com.acme.adapters.output.database.h2.service;

import br.com.acme.adapters.input.web.api.exception.errors.ClientNotFoundException;
import br.com.acme.adapters.output.database.h2.repository.ClientRepository;
import br.com.acme.application.ports.out.IDeleteClientDomainByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteClientByIdRepositoryService implements IDeleteClientDomainByIdRepository {
    private final ClientRepository clientRepository;
    @Override
    public void execute(Long id) {
        this.clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));
        this.clientRepository.deleteById(id);
    }
}
