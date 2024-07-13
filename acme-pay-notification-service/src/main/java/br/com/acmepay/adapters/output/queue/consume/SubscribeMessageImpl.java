package br.com.acmepay.adapters.output.queue.consume;

import br.com.acmepay.application.usecase.CreateNotificationUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SubscribeMessageImpl implements ConsumerMessage {

     CreateNotificationUseCase useCase;

    @Override
    public void subscribe(String ducument) {
        log.info("Subscribing to ducument {}", ducument);
        useCase.execute(ducument);
    }
}
