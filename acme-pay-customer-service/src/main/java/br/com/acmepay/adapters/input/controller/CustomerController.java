package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.CustomerRequest;
import br.com.acmepay.adapters.input.api.ICustomerResourceAPI;
import br.com.acmepay.adapters.input.api.response.CustomerResponse;
import br.com.acmepay.application.domain.models.CustomerDomain;
import br.com.acmepay.application.ports.in.ICreateCustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class CustomerController implements ICustomerResourceAPI {

    private final ICreateCustomerUseCase createCustomerUseCase;

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        var domain = CustomerDomain.builder()
                .created_at(LocalDateTime.now())
                .updated_at(null)
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .phone(customerRequest.getPhone())
                .document(customerRequest.getDocument())
                .build();
        createCustomerUseCase.execute(domain);
        return CustomerResponse.builder()
                .message("customer created!")
                .build();
    }
}
