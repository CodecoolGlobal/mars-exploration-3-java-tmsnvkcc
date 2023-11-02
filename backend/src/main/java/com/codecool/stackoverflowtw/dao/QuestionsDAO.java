package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;
import java.util.List;

public interface QuestionsDAO {
    List<Question> getAll();
    void add(String title, String description, int numberOfAnswers, int numberOfViews);
    void increaseViewCount(int id, int currentViews);
}
