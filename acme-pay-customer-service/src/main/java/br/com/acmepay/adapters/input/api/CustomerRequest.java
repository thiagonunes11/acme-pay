package br.com.acmepay.adapters.input.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {

    private String name;
    private String email;
    private String phone;
    private String document;
}
