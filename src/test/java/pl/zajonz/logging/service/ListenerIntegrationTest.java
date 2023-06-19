package pl.zajonz.logging.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import pl.zajonz.logging.model.PerformanceInfo;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ListenerTest {

    @Autowired
    private Listener listener;
    @SpyBean
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
        verify(loggingService).logPerformance(any(PerformanceInfo.class));
    }

    @Test
    void testListenMessage() {
        //given

        //when
        listener.listenInfo("test");

        //then
        verify(loggingService).logInfo(anyString());

    }
}