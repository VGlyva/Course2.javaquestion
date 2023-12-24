package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.model.Question;

import java.util.Collection;
import java.util.Collections;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Question find(String question);
    Collection<Question> getAll();
    Question getRandomQuestion();
    int size();
}
