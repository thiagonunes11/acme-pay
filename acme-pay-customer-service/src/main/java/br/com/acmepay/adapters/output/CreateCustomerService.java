package br.com.acmepay.adapters.output;

import br.com.acmepay.adapters.output.entity.CustomerEntity;
import br.com.acmepay.adapters.output.repository.CustomerRepository;
import br.com.acmepay.application.domain.models.CustomerDomain;
import br.com.acmepay.application.ports.out.ICreateCustomer;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CreateCustomerService implements ICreateCustomer {

    private final CustomerRepository repository;

    @Override
    public void execute(CustomerDomain customerDomain) {
        var entity = CustomerEntity.builder()
                .id(customerDomain.getId())
                .name(customerDomain.getName())
                .document(customerDomain.getDocument())
                .created_at(LocalDateTime.now())
                .updated_at(LocalDateTime.now())
                .salary(customerDomain.getSalary())
                .phone(customerDomain.getPhone())
                .email(customerDomain.getEmail())
                .build();

        repository.save(entity);
    }
}
