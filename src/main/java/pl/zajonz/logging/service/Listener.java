package pl.zajonz.logging.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import pl.zajonz.logging.model.PerformanceInfo;

@Service
@RequiredArgsConstructor
public class Listener {

    private final LoggingService loggingService;

    @RabbitListener(queues = "${performance-info-queue}")
    public void listenPerformance(PerformanceInfo message) {
        loggingService.logPerformance(message);
    }

    @RabbitListener(queues = "${info-queue}")
    public void listenInfo(String message) {
        loggingService.logInfo(message);
    }

}
