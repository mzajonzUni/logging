package pl.zajonz.logging.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.zajonz.logging.model.PerformanceInfo;

@Service
public class LoggingServiceImpl implements LoggingService {

    private static final Logger infoLogger = LoggerFactory.getLogger("pl.zajonz.success.info");
    private static final Logger performanceLogger = LoggerFactory.getLogger("pl.zajonz.performance.info");


    @Override
    public void logPerformance(PerformanceInfo performanceInfo) {
        performanceLogger.info("User with id: {}, email: {}, started method: {} at time: {} and the method lasted: {} ms",
                performanceInfo.getId(), performanceInfo.getEmail(),
                performanceInfo.getClassMethodName(), performanceInfo.getMethodStartTime(),
                performanceInfo.getExecutionTime());
    }

    @Override
    public void logInfo(String message) {
        infoLogger.info(message);
    }

}
