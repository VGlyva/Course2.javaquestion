package pro.sky.java.course2.examinerservice.loading;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.sky.java.course2.examinerservice.service.QuestionService;

@Component
public class Runner implements CommandLineRunner {
    private final QuestionService questionService;

    public Runner(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public void run(String... args) throws Exception {
        questionService.add("Что такое строка?"
                , "объект");
        questionService.add("Что такое int?"
                , "приметив");
        questionService.add("Что такое char?"
                , "приметив");
        questionService.add("Метод сравнения объектов?"
                , "equals");
        questionService.add("Как быстро преобразовывать в лист?"
                , "stream");
    }
}
