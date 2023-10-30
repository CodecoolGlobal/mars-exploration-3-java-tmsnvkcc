package com.codecool.stackoverflowtw.controller.dto;

import java.time.LocalDateTime;

// only those fields that are actually sent to the frontend.
// these fields could be from different tables.
public record QuestionDTO(int id, String title, String description, LocalDateTime created) {}
