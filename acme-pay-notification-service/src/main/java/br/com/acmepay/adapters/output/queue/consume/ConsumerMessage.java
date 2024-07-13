package br.com.acmepay.adapters.output.queue.consume;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public interface ConsumerMessage {
    @RabbitListener(queues = "queue_check_document")
    void subscribe(String ducument);
}
