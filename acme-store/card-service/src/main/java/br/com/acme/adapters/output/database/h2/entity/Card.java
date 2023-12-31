package br.com.acme.adapters.output.database.h2.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flag;
    private String number;
    private BigDecimal income;
    private BigDecimal card_limit;    
}
