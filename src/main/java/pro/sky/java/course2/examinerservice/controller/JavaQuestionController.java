package pro.sky.java.course2.examinerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.model.Question;
import pro.sky.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        Question question1 = new Question(question,answer);
        return questionService.remove(question1);
    }
    @GetMapping("/java/find")
    public Question findQuestion(@RequestParam String question) {
        return questionService.find(question);
    }
    @GetMapping("/java")
    public Collection<Question> findAll() {
        return questionService.getAll();
    }
}
