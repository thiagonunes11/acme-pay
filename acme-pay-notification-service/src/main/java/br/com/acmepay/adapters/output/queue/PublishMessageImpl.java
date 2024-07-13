package br.com.acmepay.adapters.output.queue;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PublishMessageImpl implements ProducerMessage{

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void publishSuccess(String documentResquest) {
        log.info("Publishing document: {}", documentResquest);
        this.rabbitTemplate.convertSendAndReceive("queue_success_document", documentResquest);
        log.info("Published document: {}", documentResquest);
    }

    @Override
    public void publishFail(String documentResquest) {
        log.info("Publishing document: {}", documentResquest);
        this.rabbitTemplate.convertSendAndReceive("queue_fail_document", documentResquest);
        log.info("Published document: {}", documentResquest);
    }
}
