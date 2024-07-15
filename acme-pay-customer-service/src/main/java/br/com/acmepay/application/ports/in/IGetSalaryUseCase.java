package br.com.acmepay.application.ports.in;

import java.math.BigDecimal;

public interface IGetSalaryUseCase {

    BigDecimal execute(String document);

}
