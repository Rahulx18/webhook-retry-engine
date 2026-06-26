package com.webhookengine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import javax.sql.DataSource;
import java.sql.Connection;
import java.time.LocalDateTime;

@Slf4j
@Component
public class HealthCheckScheduler {

    private final DataSource dataSource;
    private final long healthCheckInterval;

    public HealthCheckScheduler(DataSource dataSource,
                                @Value("${health.check.interval:60000}") long healthCheckInterval) {
        this.dataSource = dataSource;
        this.healthCheckInterval = healthCheckInterval;
    }

    @Scheduled(fixedRateString = "${health.check.interval:60000}")
    public void logHealthCheck() {
        try {
            Connection connection = dataSource.getConnection();
            boolean isValid = connection.isValid(1);
            connection.close();

            log.info("Health Check - Database: {}, Timestamp: {}", 
                isValid ? "UP" : "DOWN", 
                LocalDateTime.now());
        } catch (Exception e) {
            log.error("Health Check - Database: DOWN, Timestamp: {}, Error: {}", 
                LocalDateTime.now(), 
                e.getMessage());
        }
    }
}
