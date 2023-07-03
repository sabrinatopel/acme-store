package br.com.acme.adapters.input.web.api.request;

import java.math.BigDecimal;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardRequest {
    private String flag;
    private String number;
    private BigDecimal income;
    private BigDecimal card_limit;

    
}