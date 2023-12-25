package pro.sky.java.course2.examinerservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.examinerservice.model.Question;
import pro.sky.java.course2.examinerservice.service.ExaminerService;

import java.util.Set;

@RestController
@RequestMapping("exam/get")

public class ExaminerController {
    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("{amount}")
    public Set<Question> getQuestion(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
