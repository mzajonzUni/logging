package pl.zajonz.logging.service;

import pl.zajonz.logging.model.PerformanceInfo;

public interface LoggingService {

    void logPerformance(PerformanceInfo performanceInfo);

    void logInfo(String message);
}
