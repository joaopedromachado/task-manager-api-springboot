package br.com.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskManagerApiApplication {

    private static final Logger log = LoggerFactory.getLogger(TaskManagerApiApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(TaskManagerApiApplication.class, args);
    }

}
