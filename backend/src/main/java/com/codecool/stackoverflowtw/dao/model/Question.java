package com.codecool.stackoverflowtw.dao.model;

import java.time.LocalDateTime;

public class Question {
  private final int id;
  private final String title;
  private final String description;
  private final LocalDateTime createdAt;
  private final int numberOfAnswers;
  private final int numberOfViews;
  private final int userId;

  public Question(int id, String title, String description, LocalDateTime createdAt, int numberOfAnswers, int numberOfViews, int userId) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.createdAt = createdAt;
    this.numberOfAnswers = numberOfAnswers;
    this.numberOfViews = numberOfViews;
    this.userId = userId;
  }
}
