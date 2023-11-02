package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.AnswerPopularityCountDTO;
import com.codecool.stackoverflowtw.controller.dto.NewAnswerDTO;
import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionsForAllQuestionsPageDTO;
import com.codecool.stackoverflowtw.logger.Logger;
import com.codecool.stackoverflowtw.controller.dto.SingleQuestionDTO;
import com.codecool.stackoverflowtw.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {
  private final QuestionService questionService;
  private final Logger logger;

  @Autowired
  public QuestionController(QuestionService questionService, Logger logger) {
    this.questionService = questionService;
    this.logger = logger;
  }

  @GetMapping("/all")
  public List<QuestionsForAllQuestionsPageDTO> getAllQuestions() {
    return questionService.getAllQuestions();
  }

  @GetMapping("/{id}")
  public SingleQuestionDTO getQuestionById(@PathVariable int id) {
    return questionService.getQuestionById(id);
  }

  @PostMapping("/")
  public ResponseEntity<Object> addNewQuestion(@RequestBody NewQuestionDTO question) {
    try {
      questionService.addNewQuestion(question);
      logger.logInfo("New question added!");
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
  }

  @DeleteMapping("/{id}")
  public boolean deleteQuestionById(@PathVariable int id) {
    return false;
  }

  @PatchMapping("/increase-view-count/{id}")
  public ResponseEntity<Object> updateViewCounter(@PathVariable int id) {
    try {
      int currentViews = questionService.getQuestionById(id).numberOfViews();
      questionService.increaseViewCount(id, currentViews);
      logger.logInfo("View count updated!");
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
  }

  @GetMapping("/popularity-count/{id}")
  public AnswerPopularityCountDTO getPopularityCounts(@PathVariable int id) {
    return questionService.getPopularityCounts(id);
  }

  @PatchMapping("/update-likes/{id}")
  public ResponseEntity<Object> updateLikeCount(@PathVariable int id) {
    try {
      questionService.updateLikeCount(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
  }

  @PatchMapping("/update-dislikes/{id}")
  public ResponseEntity<Object> updateDislikeCount(@PathVariable int id) {
    try {
      questionService.updateDislikeCount(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
  }

  @PostMapping("/add-new-answer")
  public ResponseEntity<Object> postAnswer(@RequestBody NewAnswerDTO answer) {
    try {
      questionService.addAnswer(answer);
      logger.logInfo("New answer added!");
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception exception) {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
  }
}
