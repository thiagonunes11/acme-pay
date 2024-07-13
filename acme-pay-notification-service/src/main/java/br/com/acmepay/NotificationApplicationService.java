package br.com.acmepay;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class NotificationApplicationService {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplicationService.class, args);
    }
}