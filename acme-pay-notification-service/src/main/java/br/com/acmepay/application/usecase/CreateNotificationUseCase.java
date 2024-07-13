package br.com.acmepay.application.usecase;

import br.com.acmepay.adapters.output.database.entity.NotificationEntity;
import br.com.acmepay.adapters.output.database.repository.NotificationRepository;
import br.com.acmepay.adapters.output.queue.PublishMessageImpl;
import br.com.acmepay.application.domain.models.NotificationDomain;
import br.com.acmepay.application.ports.in.ICreateNotificationUseCase;
import br.com.acmepay.application.ports.out.ICreateNotification;
import br.com.acmepay.application.util.UseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@UseCase
@AllArgsConstructor
@Slf4j
public class CreateNotificationUseCase implements ICreateNotificationUseCase {

    private NotificationRepository createNotification;

    private PublishMessageImpl publishMessage;

    @Override
    public void execute(String document) {
        Optional<NotificationEntity> notificationEntity = createNotification.findByDocument(document);
        notificationEntity.ifPresent(entity -> {
            String status = entity.getStatus();
            if ("ativo".equalsIgnoreCase(status)) {
                log.info("Notification");
                publishMessage.publishSuccess(entity.getDocument());
                log.info("ativo");
            } else if ("suspenso".equalsIgnoreCase(status)) {
                log.info("Notification");
                publishMessage.publishFail(entity.getDocument());
                log.info("suspenso");
            }
        });
    }
}

