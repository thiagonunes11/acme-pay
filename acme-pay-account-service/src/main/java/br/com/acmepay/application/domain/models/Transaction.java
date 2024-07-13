package br.com.acmepay.application.domain.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Transaction {
    private AccountDomain sourceAccount;
    private AccountDomain targetAccount;
    private BigDecimal amount;
    private LocalDateTime time;
}
