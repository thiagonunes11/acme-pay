package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.IAccountResourceAPI;
import br.com.acmepay.adapters.input.api.AccountRequest;
import br.com.acmepay.adapters.input.api.response.AccountResponse;
import br.com.acmepay.adapters.output.queue.ISendMessage;
import br.com.acmepay.adapters.output.queue.service.MessageProducer;
import br.com.acmepay.application.domain.models.AccountDomain;
import br.com.acmepay.application.ports.in.ICreateAccountUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class AccountController implements IAccountResourceAPI {

    private final ICreateAccountUseCase createAccountUseCase;
    private final ISendMessage sendMessage;

    @Override
    public AccountResponse create(AccountRequest request) {
        var domain = AccountDomain.builder()
                .created_at(LocalDateTime.now())
                .updated_at(null)
                .close(false)
                .agency(request.getAgency())
                .number(request.getNumber())
                .balance(request.getBalance())
                .customerDocument(request.getDocument())
                .build();
        createAccountUseCase.execute(domain);
        sendMessage.execute("topic-1", domain);
        return AccountResponse.builder()
                .message("account created!")
                .build();
    }
}
