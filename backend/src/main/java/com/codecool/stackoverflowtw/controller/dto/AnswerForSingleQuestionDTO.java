package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDateTime;

public record AnswerForSingleQuestionDTO(int id, String description, LocalDateTime createdAt, int numberOfLikes, int numberOfDislikes, String userName) {}
