package com.example.teamvoy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class TeamvoyApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeamvoyApplication.class, args);
    }
}
