package br.com.acmepay.adapters.output.queue;

public interface ProducerMessage {

    void publishSuccess(String documentResquest);

    void publishFail(String documentResquest);
}
