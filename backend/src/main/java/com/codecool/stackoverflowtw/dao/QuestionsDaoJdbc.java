package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.postgresDb.PsqlConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionsDaoJdbc implements QuestionsDAO {
    private final PsqlConnector psqlConnector;
    private final Logger logger;

    @Autowired
    public QuestionsDaoJdbc(PsqlConnector psqlConnector, Logger logger) {
        this.psqlConnector = psqlConnector;
        this.logger = logger;
    }

    private Connection getConnection() {
        return psqlConnector.getConnection();
    }

    @Override
    public List<Question> getAll() {
        List<Question> questions = new ArrayList<>();

        String sql =
                """
                          SELECT
                            *
                          FROM
                            questions;
                        """;

        try (
                Connection conn = psqlConnector.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String description = rs.getString(3);
                LocalDateTime date = rs.getTimestamp(4).toLocalDateTime();
                int numberOfAnswers = rs.getInt(5);
                int numberOfViews = rs.getInt(6);
                int userId = rs.getInt(7);

                questions.add(new Question(id, title, description, date, numberOfAnswers, numberOfViews, userId));
            }
        } catch (SQLException exception) {
            logger.logError(exception.getMessage());
        }
        return questions;
    }


    @Override
    public void add(String title, String description,int numberOfAnswers, int numberOfViews){
        int userId = 1;
        String query = "INSERT INTO questions(title, description, numberOfAnswers, numberOfViews, userid) VALUES(?,?,?,?,?)";

        try (Connection conn = getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, numberOfAnswers);
            preparedStatement.setInt(4, numberOfViews);
            preparedStatement.setInt(5, userId);

            preparedStatement.executeUpdate();

            logger.logInfo("New question added successfully!");

            preparedStatement.close();
        } catch (SQLException e) {
            logger.logError("Error adding new question: " + e.getMessage());
        }
    }

    return questions;
  }

}
