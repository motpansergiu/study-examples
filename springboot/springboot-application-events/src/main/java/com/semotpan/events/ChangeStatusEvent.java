package com.semotpan.events;

import lombok.Value;
import org.springframework.context.ApplicationEvent;


@Value
public class ChangeStatusEvent {

    private String message;

}
