package br.com.acmepay.adapters.output.database;

import br.com.acmepay.adapters.output.database.entity.NotificationEntity;
import br.com.acmepay.adapters.output.database.repository.NotificationRepository;
import br.com.acmepay.application.ports.out.ICreateNotification;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CreateNotificationService implements ICreateNotification {

    @Override
    public Optional<NotificationEntity> findByDocument(String document) {
        return Optional.empty();
    }
}
