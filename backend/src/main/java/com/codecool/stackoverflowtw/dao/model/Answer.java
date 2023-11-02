package com.codecool.stackoverflowtw.dao.model;

import java.time.LocalDateTime;

public class Answer {
  private final int id;
  private final String description;
  private final int questionId;
  private final LocalDateTime createdAt;
  private final int numberOfLikes;
  private final int numberOfDislikes;
  private final int userId;

  public Answer(int id, String description, int questionId, LocalDateTime createdAt, int numberOfLikes, int numberOfDislikes, int userId) {
    this.id = id;
    this.description = description;
    this.questionId = questionId;
    this.createdAt = createdAt;
    this.numberOfLikes = numberOfLikes;
    this.numberOfDislikes = numberOfDislikes;
    this.userId = userId;
  }

  public int getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public int getQuestionId() {
    return questionId;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public int getNumberOfLikes() {
    return numberOfLikes;
  }

  public int getNumberOfDislikes() {
    return numberOfDislikes;
  }

  public int getUserId() {
    return userId;
  }
}
