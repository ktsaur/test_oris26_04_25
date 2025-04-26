package ru.kpfu.test_oris26_04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestOris2604Application {

    public static void main(String[] args) {
        SpringApplication.run(TestOris2604Application.class, args);
    }

}
