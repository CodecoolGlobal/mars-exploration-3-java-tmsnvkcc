package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionDTO;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.postgresDb.PsqlConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
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

  public List<QuestionDTO> getAllQuestions() {
    List<QuestionDTO> questions = new ArrayList<>();

    String sql =
      """
        SELECT
          id,
          title,
          description,
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
        String description = rs.getString(3);
        LocalDateTime date = rs.getTimestamp(4).toLocalDateTime();

        questions.add(new QuestionDTO(id, title, description, date));
      }
    } catch (SQLException exception) {
      logger.logError(exception.getMessage());
    }

    return questions;
  }

  public QuestionDTO getQuestionById(int id) {
    // TODO
    questionsDAO.sayHi();
    return new QuestionDTO(id, "example title", "example desc", LocalDateTime.now());
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

//    public List<Transaction> getAll() {

//        try (
//          Connection conn = sqliteConnector.getConnection();
//          Statement stmt = conn.createStatement();
//          ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                LocalDate date = LocalDate.parse(rs.getString("date"));
//                User user = userRepository.getUser(rs.getInt("user_id"));
//                Product product = productRepository.getProduct(rs.getInt("product_id"));
//                double pricePaid = rs.getInt("price_paid");
//
//                transactions.add(new Transaction(id, date, user, product, pricePaid));
//            }
//        } catch (SQLException exception) {
//            logger.logError(exception.getMessage());
//        }
//
//        return transactions;
//    }
