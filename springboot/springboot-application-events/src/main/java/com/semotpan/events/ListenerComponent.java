package com.semotpan.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ListenerComponent {

    @EventListener
    public void handleEvent(ChangeStatusEvent event) {

        log.info("Received event : {}" , event);
        log.info("Current thread {} ", Thread.currentThread());
    }

}
