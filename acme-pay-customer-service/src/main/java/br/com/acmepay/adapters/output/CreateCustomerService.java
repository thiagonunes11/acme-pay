package br.com.acmepay.adapters.output;

import br.com.acmepay.adapters.output.entity.CustomerEntity;
import br.com.acmepay.adapters.output.repository.CustomerRepository;
import br.com.acmepay.application.domain.models.CustomerDomain;
import br.com.acmepay.application.ports.out.ICreateCustomer;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCustomerService implements ICreateCustomer {

    private final CustomerRepository repository;

    @Override
    public void execute(CustomerDomain customerDomain) {

    }
}
