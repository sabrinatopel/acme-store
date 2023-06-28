package br.com.acme.application.ports.out;

public interface IDeleteCardDomainByIdRepository {
    
    void execute(Long id);
}
