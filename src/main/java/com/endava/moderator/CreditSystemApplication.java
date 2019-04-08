package com.endava.moderator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.endava.moderator.model", "com.endava.moderator.repository"})
public class CreditSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CreditSystemApplication.class, args);
    }
}
