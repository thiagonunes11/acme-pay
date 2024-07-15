package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.CustomerRequest;
import br.com.acmepay.adapters.input.api.GetSalaryRequest;
import br.com.acmepay.adapters.input.api.ICustomerResourceAPI;
import br.com.acmepay.adapters.input.api.response.CustomerResponse;
import br.com.acmepay.application.domain.models.CustomerDomain;
import br.com.acmepay.application.ports.in.ICreateCustomerUseCase;
import br.com.acmepay.application.ports.in.IGetSalaryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class CustomerController implements ICustomerResourceAPI {

    private final ICreateCustomerUseCase createCustomerUseCase;
    private final IGetSalaryUseCase getSalaryUseCase;

    @Override
    public CustomerResponse create(CustomerRequest customerRequest) {
        var domain = CustomerDomain.builder()
                .created_at(LocalDateTime.now())
                .updated_at(null)
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .phone(customerRequest.getPhone())
                .document(customerRequest.getDocument())
                .salary(customerRequest.getSalary())
                .build();
        createCustomerUseCase.execute(domain);
        return CustomerResponse.builder()
                .message("customer created!")
                .build();
    }

    @Override
    public BigDecimal getSalary(GetSalaryRequest document) {
        return getSalaryUseCase.execute(document.getDocument());
    }
}
