package com.webhookengine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebhookRetryEngineApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebhookRetryEngineApplication.class, args);
    }

}
