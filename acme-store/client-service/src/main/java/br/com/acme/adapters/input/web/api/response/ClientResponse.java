package br.com.acme.adapters.input.web.api.response;

import br.com.acme.adapters.input.web.api.request.CardRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
    private List<CardResponse> cards;

}
