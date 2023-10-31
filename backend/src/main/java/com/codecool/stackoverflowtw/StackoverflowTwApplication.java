package com.codecool.stackoverflowtw;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.dao.QuestionsDaoJdbc;
import com.codecool.stackoverflowtw.logger.ConsoleLogger;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.sqlitedb.SqliteConnector;
import com.codecool.stackoverflowtw.sqlitedb.SqliteConnectorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StackoverflowTwApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackoverflowTwApplication.class, args);
    }

    @Bean
    public QuestionsDAO questionsDAO() {
        return new QuestionsDaoJdbc();
    }

    @Bean
    Logger getLogger() {
        return new ConsoleLogger();
    }

    @Bean
    SqliteConnector getDBConnector() {
        return new SqliteConnectorImpl(getLogger());
    }
}
