package br.com.acmepay.application.ports.out;

public interface INotificationQueue {
    void execute(String document);
}
