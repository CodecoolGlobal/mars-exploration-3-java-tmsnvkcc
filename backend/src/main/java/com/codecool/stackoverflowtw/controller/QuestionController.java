package com.codecool.stackoverflowtw.controller;

import com.codecool.stackoverflowtw.controller.dto.NewQuestionDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionsForAllQuestionsPageDTO;
import com.codecool.stackoverflowtw.controller.dto.QuestionForHomePageListDTO;
import com.codecool.stackoverflowtw.logger.Logger;
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
    public QuestionsForAllQuestionsPageDTO getQuestionById(@PathVariable int id) {
        return null;
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
}
