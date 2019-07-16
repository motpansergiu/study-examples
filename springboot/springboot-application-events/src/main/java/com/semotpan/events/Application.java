package com.semotpan.events;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
@AllArgsConstructor
@Slf4j
public class Application implements CommandLineRunner {

    private final ApplicationEventPublisher applicationEventPublisher;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        final TimeHelper timeHelper = new TimeHelper();

        Stream.iterate(1, value -> value + 1)
                .limit(5)
                .forEach((value) -> {
                    log.info("#################################################");
                    log.info("Current thread {} ", Thread.currentThread());
                    applicationEventPublisher.send(" ->>> Message -> " + value);
                    timeHelper.sleep(1000);
                });

    }

    static class TimeHelper {
        void sleep(long delay) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
