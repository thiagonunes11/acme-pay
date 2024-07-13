package br.com.acmepay.adapters.output.database.repository;

import br.com.acmepay.adapters.output.database.entity.NotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    Optional<NotificationEntity> findByDocument(String document);
}
