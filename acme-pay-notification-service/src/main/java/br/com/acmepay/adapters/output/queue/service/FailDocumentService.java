package br.com.acmepay.adapters.output.queue.service;

import br.com.acmepay.adapters.output.queue.PublishMessageImpl;
import br.com.acmepay.application.ports.out.INotificationQueue;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class FailDocumentService implements INotificationQueue {

    private final PublishMessageImpl producerMessage;

    public void execute(String document) {
        producerMessage.publishFail(document);
        log.info("Publish fail Check document {}", document);

    }
}
