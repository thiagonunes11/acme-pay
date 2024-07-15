package br.com.acmepay.adapters.input.api;

import br.com.acmepay.adapters.input.api.response.CustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("/api/v1/customers")
public interface ICustomerResourceAPI {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    CustomerResponse create(@RequestBody CustomerRequest request);


    @GetMapping("/salary")
    @ResponseStatus(HttpStatus.OK)
    BigDecimal getSalary(@RequestBody GetSalaryRequest document);

}
