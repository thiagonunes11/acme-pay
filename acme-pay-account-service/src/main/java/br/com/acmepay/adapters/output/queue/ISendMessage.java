package br.com.acmepay.adapters.output.queue;


public interface ISendMessage {
    void execute (String topic,  Object message);
}
