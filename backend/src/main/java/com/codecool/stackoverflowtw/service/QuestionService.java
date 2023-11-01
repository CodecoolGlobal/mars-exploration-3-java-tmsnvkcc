package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionForHomePageListDTO;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.postgresDb.PsqlConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
  private QuestionsDAO questionsDAO;
  private PsqlConnector psqlConnector;
  private Logger logger;

  @Autowired
  public QuestionService(QuestionsDAO questionsDAO, PsqlConnector psqlConnector, Logger logger) {
    this.questionsDAO = questionsDAO;
    this.psqlConnector = psqlConnector;
    this.logger = logger;
  }

  public List<QuestionForHomePageListDTO> getAllQuestions() {
    List<QuestionForHomePageListDTO> questions = new ArrayList<>();

    String sql =
      """
        SELECT
          questions.id,
          users.username,
          questions.title,
          questions.numberofanswers,
          questions.numberofviews,
          questions.createdat
        FROM
          questions
        INNER JOIN users ON questions.userid = users.id;
      """;

    try (
      Connection conn = psqlConnector.getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql)) {

      while (rs.next()) {
        int id = rs.getInt(1);
        String userName = rs.getString(2);
        String title = rs.getString(3);
        int numberOfAnswers = rs.getInt(4);
        int numberOfViews = rs.getInt(5);
        LocalDateTime date = rs.getTimestamp(6).toLocalDateTime();

        questions.add(new QuestionForHomePageListDTO(id, userName, title, numberOfAnswers, numberOfViews, date));
      }
    } catch (SQLException exception) {
      logger.logError(exception.getMessage());
    }

    return questions;
  }

  public QuestionForHomePageListDTO getQuestionById(int id) {
    // TODO - this will need a different DTO object.
    questionsDAO.sayHi();
    return null;
//    return new QuestionDTO(id, "example title", "example desc", LocalDateTime.now());
  }

  public boolean deleteQuestionById(int id) {
    // TODO
    return false;
  }

  public int addNewQuestion(NewQuestionDTO question) {
    // TODO
    int createdId = 0;
    return createdId;
  }
}
