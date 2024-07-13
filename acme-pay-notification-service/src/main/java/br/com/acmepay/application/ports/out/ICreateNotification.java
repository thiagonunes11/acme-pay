package br.com.acmepay.application.ports.out;

import br.com.acmepay.adapters.output.database.entity.NotificationEntity;

import java.util.Optional;

public interface ICreateNotification {

    Optional<NotificationEntity> findByDocument(String document);
}
