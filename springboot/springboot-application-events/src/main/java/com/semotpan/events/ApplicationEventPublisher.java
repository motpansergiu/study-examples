package com.semotpan.events;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Slf4j
public class ApplicationEventPublisher {

    private org.springframework.context.ApplicationEventPublisher publisher;

    public void send(String message) {

        publisher.publishEvent(new ChangeStatusEvent(message));
        log.info("Event published : {}", message);
    }

}
