package br.com.acmepay.adapters.input.controller;

import br.com.acmepay.adapters.input.api.IAccountResourceAPI;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements IAccountResourceAPI {

    @Override
    public String test() {
        return "response to call";
    }
}
