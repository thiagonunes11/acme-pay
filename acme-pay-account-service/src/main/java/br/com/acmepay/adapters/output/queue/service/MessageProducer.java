package br.com.acmepay.adapters.output.queue.service;

import br.com.acmepay.adapters.output.queue.ISendMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageProducer implements ISendMessage {

    private final KafkaTemplate<String, Object> kafkaTemplate;


    @Override
    public void execute(String topic, Object message) {
        kafkaTemplate.send(topic, message);
    }

}
