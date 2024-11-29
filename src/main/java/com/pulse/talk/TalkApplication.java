package com.pulse.talk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(TalkApplication.class, args);
    }

}
