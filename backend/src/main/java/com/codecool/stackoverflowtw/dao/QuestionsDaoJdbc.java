package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.postgresDb.PsqlConnector;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class QuestionsDaoJdbc implements QuestionsDAO {
    private final Logger logger;
    private final PsqlConnector psqlConnector;

    public QuestionsDaoJdbc(Logger logger, PsqlConnector psqlConnector) {
        this.logger = logger;
        this.psqlConnector = psqlConnector;
    }
    private Connection getConnection() {
        return psqlConnector.getConnection();
    }

    @Override
    public void sayHi() {
        System.out.println("Hi DAO!");
    }

    @Override
    public void add(String title, String description, int numberOfLikes, int numberOfViews) {
        int userId = 1;
        String query = "INSERT INTO questions(title, description, numberOfAnswers, numberOfViews, userid) VALUES(?,?,?,?,?)";

        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, numberOfLikes);
            preparedStatement.setInt(4, numberOfViews);
            preparedStatement.setInt(5, userId);

            preparedStatement.executeUpdate();

            logger.logInfo("Adding a new question was successfull!");

            preparedStatement.close();
        } catch (SQLException e) {
            logger.logError("Error adding new question: " + e.getMessage());
        }
    }


}
