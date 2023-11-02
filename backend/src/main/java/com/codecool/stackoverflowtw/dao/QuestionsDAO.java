package com.codecool.stackoverflowtw.dao;

import com.codecool.stackoverflowtw.dao.model.Question;
import java.util.List;

public interface QuestionsDAO {
    void add(String title, String description, int numberOfLikes, int numberOfViews);
    List<Question> getAll();
}
