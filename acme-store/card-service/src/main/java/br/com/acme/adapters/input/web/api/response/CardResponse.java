package br.com.acme.adapters.input.web.api.response;

import java.math.BigDecimal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardResponse {
    private Long id;
    private String flag;
    private String number;
    private BigDecimal income;
    private BigDecimal card_limit;

    
}