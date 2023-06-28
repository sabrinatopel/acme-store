package br.com.acme.adapters.output.database.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.adapters.output.database.mysql.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long>{ 
}
