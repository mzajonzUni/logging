package pl.zajonz.logging.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import pl.zajonz.logging.model.PerformanceInfo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(OutputCaptureExtension.class)
class LoggingServiceImplTest {

    private final LoggingServiceImpl loggingService = new LoggingServiceImpl();

    @Test
    void logPerformance(CapturedOutput output) {
        PerformanceInfo performanceInfo = new PerformanceInfo();
        performanceInfo.setId(1);
        performanceInfo.setMethodStartTime(LocalDateTime.now());
        performanceInfo.setEmail("test@test.pl");
        performanceInfo.setClassMethodName("test.test(..)");
        performanceInfo.setExecutionTime(10L);
        loggingService.logPerformance(performanceInfo);

        assertTrue(output.getOut().contains("User with id: " + performanceInfo.getId() + ", email: "
                + performanceInfo.getEmail() + ", started method: " + performanceInfo.getClassMethodName()
                + " at time: " + performanceInfo.getMethodStartTime() + " and the method lasted: "
                + performanceInfo.getExecutionTime() + " ms"));
    }

    @Test
    void logInfo(CapturedOutput output) {
        loggingService.logInfo("test");
        assertTrue(output.getOut().contains("test"));
    }
}