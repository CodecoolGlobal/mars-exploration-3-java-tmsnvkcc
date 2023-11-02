package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Answer;
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
public class AnswersDAOJdbc implements AnswersDAO {
  private PsqlConnector psqlConnector;
  private Logger logger;

  @Autowired
  public AnswersDAOJdbc(PsqlConnector psqlConnector, Logger logger) {
    this.psqlConnector = psqlConnector;
    this.logger = logger;
  }

  @Override
  public List<Answer> getAnswersByQuestionId(int questionId) {
    List<Answer> answers = new ArrayList<>();

    String sql =
      """
        SELECT
          *
        FROM
          answers
        WHERE
          questionid = ?;
      """;

    try (
      Connection conn = psqlConnector.getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setInt(1, questionId);
      ResultSet rs = pstmt.executeQuery();

      while (rs.next()) {
        int id = rs.getInt(1);
        String description = rs.getString(2);
        int questionid = rs.getInt(3);
        LocalDateTime date = rs.getTimestamp(4).toLocalDateTime();
        int numberOfLikes = rs.getInt(5);
        int numberOfDislikes = rs.getInt(6);
        int userId = rs.getInt(7);

        answers.add(new Answer(id, description, questionid, date, numberOfLikes, numberOfDislikes, userId));
      }
    } catch (SQLException exception) {
      logger.logError(exception.getMessage());
    }

    return answers;
  }
}
