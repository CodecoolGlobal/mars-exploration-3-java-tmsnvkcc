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
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionsDaoJdbc implements QuestionsDAO {
  private PsqlConnector psqlConnector;
  private Logger logger;

  @Autowired
  public QuestionsDaoJdbc(PsqlConnector psqlConnector, Logger logger) {
    this.psqlConnector = psqlConnector;
    this.logger = logger;
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
}
