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
          id,
          title,
          numberofanswers,
          numberofviews,
          createdat
        FROM
          questions;
        """;

    try (
      Connection conn = psqlConnector.getConnection();
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql)) {

      while (rs.next()) {
        int id = rs.getInt(1);
        String title = rs.getString(2);
        int numberOfAnswers = rs.getInt(3);
        int numberOfViews = rs.getInt(4);
        LocalDateTime date = rs.getTimestamp(5).toLocalDateTime();

        questions.add(new QuestionForHomePageListDTO(id, title, numberOfAnswers, numberOfViews, date));
      }
    } catch (SQLException exception) {
      logger.logError(exception.getMessage());
    }

    return questions;
  }

  public QuestionForHomePageListDTO getQuestionById(int id) {
    // TODO
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
