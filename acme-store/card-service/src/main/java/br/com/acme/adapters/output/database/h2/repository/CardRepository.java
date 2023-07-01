package br.com.acme.adapters.output.database.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.acme.adapters.output.database.h2.entity.Card;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{ 
}
