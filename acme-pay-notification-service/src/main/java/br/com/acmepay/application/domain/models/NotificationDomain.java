package br.com.acmepay.application.domain.models;

import br.com.acmepay.adapters.output.database.entity.NotificationEntity;
import br.com.acmepay.adapters.output.database.repository.NotificationRepository;
import br.com.acmepay.application.ports.out.ICreateNotification;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDomain {
    private Long id;
    private String document;
    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Optional<NotificationEntity> find(NotificationRepository notificationRepository) {
        return notificationRepository.findByDocument(this.document);
    }
}
