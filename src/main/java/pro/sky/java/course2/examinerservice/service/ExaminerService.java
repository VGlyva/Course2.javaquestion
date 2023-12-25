package pro.sky.java.course2.examinerservice.service;

import pro.sky.java.course2.examinerservice.model.Question;

import java.util.Collection;
import java.util.Set;

public interface ExaminerService {
    Set<Question> getQuestions(int amount);
}
