package com.codecool.stackoverflowtw.service;

import com.codecool.stackoverflowtw.controller.dto.AnswerForSingleQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.SingleQuestionDTO;
import com.codecool.stackoverflowtw.dao.AnswersDAO;
import com.codecool.stackoverflowtw.dao.QuestionsDAO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionsForAllQuestionsPageDTO;
import com.codecool.stackoverflowtw.dao.UserDAO;
import com.codecool.stackoverflowtw.dao.model.Answer;
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
  private final AnswersDAO answersDAOJdbc;
  private final UserDAO userDAOJdbc;
  private final Logger logger;

  @Autowired
  public QuestionService(QuestionsDAO questionsDAOJdbc, AnswersDAO answersDAOJdbc, UserDAO userDAOJdbc, Logger logger) {
      this.questionsDAOJdbc = questionsDAOJdbc;
      this.answersDAOJdbc = answersDAOJdbc;
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

  public SingleQuestionDTO getQuestionById(int id) {
    SingleQuestionDTO questionWithAnswers;
    List<AnswerForSingleQuestionDTO> answers = new ArrayList<>();

    Question questionsDAO = questionsDAOJdbc.getAll().stream()
      .filter(question -> question.getId() == id)
      .collect(Collectors.toList())
      .get(0);
    List<User> usersDAO = userDAOJdbc.getAll();
    List<Answer> answersDAO = answersDAOJdbc.getAnswersByQuestionId(id);

    int questionId = questionsDAO.getId();
    String title = questionsDAO.getTitle();
    String description = questionsDAO.getDescription();
    LocalDateTime createdAt = questionsDAO.getCreatedAt();
    int numberOfViews = questionsDAO.getNumberOfViews();
    String userName = usersDAO.stream()
      .filter(user -> user.getId() == questionsDAO.getUserId())
      .collect(Collectors.toList())
      .get(0).getUsername();

    for (Answer answer : answersDAO) {
      int answerId = answer.getId();
      String answerDescription = answer.getDescription();
      LocalDateTime answerCreatedAt = answer.getCreatedAt();
      int numberOfLikes = answer.getNumberOfLikes();
      int numberOfDislikes = answer.getNumberOfDislikes();
      String answerUserName = usersDAO.stream()
        .filter(user -> user.getId() == answer.getUserId())
        .collect(Collectors.toList())
        .get(0).getUsername();

      answers.add(new AnswerForSingleQuestionDTO(answerId, answerDescription, answerCreatedAt, numberOfLikes, numberOfDislikes, answerUserName));
    }

    questionWithAnswers = new SingleQuestionDTO(questionId, title, description, createdAt, numberOfViews, userName, answers);

    return questionWithAnswers;
  }

  public boolean deleteQuestionById(int id) {
    // TODO
    return false;
  }

  public void addNewQuestion(NewQuestionDTO question) {
    questionsDAOJdbc.add(question.title(), question.description(), NUMBER_OF_ANSWERS, NUMBER_OF_VIEWS);
  }
}
