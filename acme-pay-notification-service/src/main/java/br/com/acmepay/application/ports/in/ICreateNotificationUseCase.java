package br.com.acmepay.application.ports.in;

import br.com.acmepay.application.domain.models.NotificationDomain;

public interface ICreateNotificationUseCase {
    void execute(String document);
}
