package br.com.acme.adapters.input.web.api.request;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientRequest {
    private String name;
    private String email;
    private String document;
    private String phone;
    private BigDecimal income;
    private List<CardRequest> cards;
    
}
