package br.com.acme.application.ports.in;

public interface IDeleteClientCardDomainByIdUseCase {
     void execute(Long id, Long card_id);
}
