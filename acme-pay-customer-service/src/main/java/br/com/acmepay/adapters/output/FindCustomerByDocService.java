package br.com.acmepay.adapters.output;

import br.com.acmepay.adapters.output.repository.CustomerRepository;
import br.com.acmepay.application.domain.models.CustomerDomain;
import br.com.acmepay.application.ports.out.IFindCustomerByDoc;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class FindCustomerByDocService implements IFindCustomerByDoc {

    private final CustomerRepository customerRepository;
    @Override
    public CustomerDomain execute(String doc) {

        log.info("--- documento: {} ",doc);

        var result = customerRepository.findByDocument(doc);

        if (result.isEmpty()){
            return null;
        }

        var entity = result.get();
        var response = CustomerDomain.builder()
                .id(entity.getId())
                .name(entity.getName())
                .created_at(entity.getCreated_at())
                .updated_at(entity.getUpdated_at())
                .document(entity.getDocument())
                .salary(entity.getSalary())
                .phone(entity.getPhone())
                .build();

        return response;
    }
}
