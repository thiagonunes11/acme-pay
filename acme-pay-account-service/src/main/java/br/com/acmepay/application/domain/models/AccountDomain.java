package br.com.acmepay.application.domain.models;


import br.com.acmepay.application.domain.models.exception.BalanceToWithdrawException;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDomain {
    private Long id;
    private Integer number;
    private Integer agency;
    private BigDecimal balance;
    private String customer;
    private LocalDateTime created_at;
    private LocalDateTime update_at;
    private Boolean closed;

    public void create(AccountDomain account) {
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount)  throws BalanceToWithdrawException {
        if (checkBalanceAuthorized(amount)){
            this.balance = this.balance.subtract(amount);
        } else {
            throw new BalanceToWithdrawException("Transaction failed");
        }
    }

    public void transfer(BigDecimal amount, AccountDomain accountDest) throws BalanceToWithdrawException {
        this.withdraw(amount);
        accountDest.deposit(amount);
    }

//    public List<String> accountStatement(AccountDomain accout) {
//        return this.transactions;
//    }

    private boolean checkBalanceAuthorized(BigDecimal amount) {
        return this.balance.compareTo(amount) >= 0;
    }
}
