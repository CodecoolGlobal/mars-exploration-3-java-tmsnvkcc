package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionsForAllQuestionsPageDTO;
import com.codecool.stackoverflowtw.dao.UserDAO;
import com.codecool.stackoverflowtw.dao.model.Question;
import com.codecool.stackoverflowtw.dao.model.User;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.postgresDb.PsqlConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
  public static final int NUMBER_OF_ANSWERS = 0;
  public static final int NUMBER_OF_VIEWS = 0;
  private final QuestionsDAO questionsDAOJdbc;
  private final UserDAO userDAOJdbc;
  private final Logger logger;

  @Autowired
  public QuestionService(QuestionsDAO questionsDAOJdbc, UserDAO userDAOJdbc, Logger logger) {
      this.questionsDAOJdbc = questionsDAOJdbc;
      this.userDAOJdbc = userDAOJdbc;
      this.logger = logger;
  }

  public List<QuestionsForAllQuestionsPageDTO> getAllQuestions() {
    List<QuestionsForAllQuestionsPageDTO> questions = new ArrayList<>();

      List<Question> questionsDAO = questionsDAOJdbc.getAll();
      List<User> usersDAO = userDAOJdbc.getAll();

    for (Question question : questionsDAO) {
      int id = question.getId();
      String title = question.getTitle();
      int numberOfAnswers = question.getNumberOfAnswers();
      int numberOfViews = question.getNumberOfViews();
      LocalDateTime createdAt = question.getCreatedAt();
      String userName = usersDAO.stream()
                                .filter(user -> user.getId() == question.getUserId())
                                .collect(Collectors.toList())
                                .get(0).getUsername();

      questions.add(new QuestionsForAllQuestionsPageDTO(id, userName, title, numberOfAnswers, numberOfViews, createdAt));
    }

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

  public void addNewQuestion(NewQuestionDTO question) {
    questionsDAOJdbc.add(question.title(), question.description(), NUMBER_OF_ANSWERS, NUMBER_OF_VIEWS);
  }
}
