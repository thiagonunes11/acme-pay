package br.com.acmepay.adapters.output.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "notifications")
public class NotificationEntity {

    @Id
    @SequenceGenerator(name = "notification_seq",
            sequenceName = "notification_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "notification_seq")
    private Long id;

    private String document;
    private String status;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}

