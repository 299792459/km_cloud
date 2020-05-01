package com.km.km_erukaserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class KmErukaserverApplication {

    private final static Logger logger = LoggerFactory.getLogger(KmErukaserverApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(KmErukaserverApplication.class, args);
        logger.info("SpringBoot Start Success");
    }

}
