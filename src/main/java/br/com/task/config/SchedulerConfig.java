package br.com.task.config;

import br.com.task.service.SchedulerService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    private final SchedulerService schedulerService;

    public SchedulerConfig(SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

//    @Scheduled(cron = "0 0 12 * * ?")
    @Scheduled(fixedDelay = 5000)
    public void runDeleteTasksEveryMiddleDay() {
        schedulerService.deleteOldTasksCompleted();
    }
}
