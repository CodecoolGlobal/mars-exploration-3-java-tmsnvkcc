package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDateTime;
import java.util.List;

public record SingleQuestionDTO(int id, String title, String description, LocalDateTime createdAt, int numberOfViews, String userName, List<AnswerForSingleQuestionDTO> answerForSingleQuestionDTOs) {}
