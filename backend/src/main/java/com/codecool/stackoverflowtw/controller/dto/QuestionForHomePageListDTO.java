package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDateTime;

// only those fields that are actually sent to the frontend.
// these fields could be from different tables.
public record QuestionForHomePageListDTO(int id, String userName, String title, int numberOfAnswers, int numberOfViews, LocalDateTime createdAt) {}
