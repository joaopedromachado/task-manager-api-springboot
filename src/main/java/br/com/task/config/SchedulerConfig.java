package br.com.task.config;

import br.com.task.service.SchedulerService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    private final SchedulerService schedulerService;

    public SchedulerConfig(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void runDeleteTasksEveryMiddleDay() {
        schedulerService.deleteOldTasksCompleted();
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void runCleanLogsEvery() throws IOException {
        schedulerService.cleanLogs();
    }
}
