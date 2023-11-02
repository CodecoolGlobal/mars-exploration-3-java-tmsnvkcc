package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionsForAllQuestionsPageDTO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.postgresDb.PsqlConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
  private QuestionsDAO questionsDAOJdbc;
  private Logger logger;

  @Autowired
  public QuestionService(QuestionsDAO questionsDAOJdbc, Logger logger) {
    this.questionsDAOJdbc = questionsDAOJdbc;
    this.logger = logger;
  }

  public List<QuestionsForAllQuestionsPageDTO> getAllQuestions() {
    List<QuestionsForAllQuestionsPageDTO> questions = new ArrayList<>();

    List<Question> questionsDAO = questionsDAOJdbc.getAll();
//    String sql =
//      """
//        SELECT
//          questions.id,
//          users.username,
//          questions.title,
//          questions.numberofanswers,
//          questions.numberofviews,
//          questions.createdat
//        FROM
//          questions
//        INNER JOIN users ON questions.userid = users.id;
//      """;

//    try (
//      Connection conn = psqlConnector.getConnection();
//      Statement stmt = conn.createStatement();// prepared statements
//      ResultSet rs = stmt.executeQuery(sql)) {
//
//      while (rs.next()) {
//        int id = rs.getInt(1);
//        String userName = rs.getString(2);
//        String title = rs.getString(3);
//        int numberOfAnswers = rs.getInt(4);
//        int numberOfViews = rs.getInt(5);
//        LocalDateTime date = rs.getTimestamp(6).toLocalDateTime();
//
//        questions.add(new QuestionsForAllQuestionsPageDTO(id, userName, title, numberOfAnswers, numberOfViews, date));
//      }
//    } catch (SQLException exception) {
//      logger.logError(exception.getMessage());
//    }

    return questions;
  }

  public QuestionsForAllQuestionsPageDTO getQuestionById(int id) {
    // TODO - this will need a different DTO object.
//    questionsDAO.sayHi();
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
