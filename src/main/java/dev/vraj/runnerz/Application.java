package dev.vraj.runnerz;

import dev.vraj.runnerz.run.Location;
import dev.vraj.runnerz.run.Run;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(){

    return args -> {
        Run run = new Run(1,"First Run", LocalDateTime.now() ,LocalDateTime.now().plus(1, ChronoUnit.HOURS),5, Location.OUTDOOR);
        log.info("Run:" +  run);
    };
    }

}
