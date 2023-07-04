package br.com.acme.application.ports.out;

public interface IDeleteClientCardDomainByIdRepository {

    void execute(Long id, Long card_id);
    
}
