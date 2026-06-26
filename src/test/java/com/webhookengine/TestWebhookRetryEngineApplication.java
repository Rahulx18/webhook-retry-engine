package com.webhookengine;

import org.springframework.boot.SpringApplication;

public class TestWebhookRetryEngineApplication {

    public static void main(String[] args) {
        SpringApplication.from(WebhookRetryEngineApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
