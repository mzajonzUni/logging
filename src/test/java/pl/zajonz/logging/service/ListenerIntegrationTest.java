package pl.zajonz.logging.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import pl.zajonz.logging.model.PerformanceInfo;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
class ListenerIntegrationTest {

    @Autowired
    private Listener listener;
    @MockBean
    private LoggingService loggingService;

    @Test
    void testListenPerformance() {
        //given
        PerformanceInfo performanceInfo = new PerformanceInfo();
        performanceInfo.setId(1);
        performanceInfo.setMethodStartTime(LocalDateTime.now());
        performanceInfo.setEmail("test@test.pl");
        performanceInfo.setClassMethodName("test.test(..)");
        performanceInfo.setExecutionTime(10L);

        //when
        listener.listenPerformance(performanceInfo);

        //then
        verify(loggingService, times(1)).logPerformance(any(PerformanceInfo.class));
    }

    @Test
    void testListenMessage() {
        //given

        //when
        listener.listenInfo("test");

        //then
        verify(loggingService, times(1)).logInfo(anyString());
    }
}