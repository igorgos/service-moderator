package com.endava.moderator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.endava.moderator.model", "com.endava.moderator.repository", "com.endava.moderator.business"})
public class ServiceModeratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceModeratorApplication.class, args);
    }
}
