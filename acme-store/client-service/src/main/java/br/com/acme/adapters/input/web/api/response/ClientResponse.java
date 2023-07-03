package br.com.acme.adapters.input.web.api.response;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientResponse {
    private Long id;
    private String name;
    private String email;
    private String document;
    private String phone;
    private BigDecimal income;
    private List<CardResponse> cards;

}
