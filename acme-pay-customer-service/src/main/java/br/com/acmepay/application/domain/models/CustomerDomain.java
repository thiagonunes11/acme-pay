package br.com.acmepay.application.domain.models;

import br.com.acmepay.application.ports.out.ICreateCustomer;
import br.com.acmepay.application.ports.out.IFindCustomerByDoc;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDomain {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String document;
    //private List<Account> accounts;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private BigDecimal salary;

    private List<CustomerDomain> customers = new ArrayList<>();

    public void create(ICreateCustomer createCustomer) {
        createCustomer.execute(this);
    }

    public List<CustomerDomain> listCustomer()  {
        return this.customers;
    }

    public void delete(CustomerDomain customer) {
    }

    public void update(CustomerDomain customer) {
        this.name = customer.getName();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.document = customer.getDocument();
        customer.setUpdated_at(LocalDateTime.now());
    }

    public Optional<CustomerDomain> getByCustomerDocument(String document) {
        return this.customers.stream().filter(c -> c.getDocument().equals(document)).findFirst();
    }

    public Boolean validCustomerCreated (CustomerDomain customer) {
        return this.customers.stream()
                .filter(c -> c.getEmail().equals(customer.email) && c.getDocument().equals(customer.document))
                .anyMatch(customer1 -> true);
    }

    public Boolean validDocumentCustomer (String document) {
        int length = document.length();
        return length == 11 || length == 20;
    }

    public BigDecimal getSalaryByDoc (String document, IFindCustomerByDoc findCustomerByDoc){
        var user = findCustomerByDoc.execute(document);

        return user.getSalary();
    }
}
