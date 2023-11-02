package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Answer;

import java.util.List;

public interface AnswersDAO {
  List<Answer> getAnswersByQuestionId(int questionId);
  Answer getAnswerById(int answerId);
  void updateLikeCountById(int answerId, int newValue);
  void updateDislikeCountById(int answerId, int newValue);
  void add(int questionId, String body);
}
