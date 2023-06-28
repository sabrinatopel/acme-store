package br.com.acme.adapters.input.web.api.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientRequest {
    private String name;
    private String email;
    private String document;
    private String phone;
    
}
