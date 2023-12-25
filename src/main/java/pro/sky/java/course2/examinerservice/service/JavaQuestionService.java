package pro.sky.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examinerservice.exception.QuestionNotFoundException;
import pro.sky.java.course2.examinerservice.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Random random = new Random();
    private final List<Question> questions;

    public JavaQuestionService(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question,answer));
    }
    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new IllegalArgumentException("Вопрос уже был");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {

        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException("Элемента нет в списке");
    }
    @Override
    public Question find(String question) {
        return questions.stream()
                .filter(e ->e.getQuestion().equals(question))
                .findFirst()
                .orElseThrow(QuestionNotFoundException::new);
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int i = random.nextInt(questions.size());
        return questions.get(i);
    }
    @Override
    public int size() {
        return questions.size();
    }
}
