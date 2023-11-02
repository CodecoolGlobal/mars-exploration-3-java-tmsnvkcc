package com.codecool.stackoverflowtw;

import com.codecool.stackoverflowtw.logger.ConsoleLogger;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.postgresDb.PsqlConnector;
import com.codecool.stackoverflowtw.postgresDb.PsqlConnectorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StackoverflowTwApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowTwApplication.class, args);
    }



    @Bean
    Logger getLogger() {
        return new ConsoleLogger();
    }

    @Bean
    PsqlConnector getDBConnector() {
        return new PsqlConnectorImpl(getLogger());
    }
}
