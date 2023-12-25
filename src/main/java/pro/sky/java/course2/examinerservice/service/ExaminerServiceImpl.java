package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.exception.FullSetException;
import pro.sky.java.course2.examinerservice.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Set<Question> getQuestions(int amount) {
        if(amount > questionService.size()) {
            throw new FullSetException("Превышено максимальное число вопросов");
        }
        Set<Question> setQuestion = new HashSet<>();
        while (setQuestion.size() < amount) {
            setQuestion.add(questionService.getRandomQuestion());
        }
        return setQuestion;
    }
}
