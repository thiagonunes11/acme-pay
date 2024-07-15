package br.com.acmepay.application.usecase;

import br.com.acmepay.application.domain.models.CustomerDomain;
import br.com.acmepay.application.ports.in.IGetSalaryUseCase;
import br.com.acmepay.application.ports.out.IFindCustomerByDoc;
import br.com.acmepay.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@UseCase
@AllArgsConstructor
public class GetCustomerSalaryUseCase implements IGetSalaryUseCase {

    private final IFindCustomerByDoc findCustomerByDoc;

    @Override
    public BigDecimal execute(String document) {

        var domain = CustomerDomain.builder().build();

        return domain.getSalaryByDoc(document, findCustomerByDoc);
    }
}
