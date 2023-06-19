package pl.zajonz.logging.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.zajonz.logging.model.PerformanceInfo;

@Service
@Slf4j
public class LoggingServiceImpl implements LoggingService {
    
    public void logPerformance(PerformanceInfo performanceInfo){
        log.info("User with id: {}, email: {}, started method: {} at time: {} and the method lasted: {} ms",
                performanceInfo.getId(), performanceInfo.getEmail(),
                performanceInfo.getClassMethodName(), performanceInfo.getMethodStartTime(),
                performanceInfo.getExecutionTime());
    }
    
}
