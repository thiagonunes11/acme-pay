package br.com.acmepay.application.ports.out;

import br.com.acmepay.adapters.requests.DocumentResquest;

public interface ICheckDocumentCustomer {
    void execute(DocumentResquest request);
}
