package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.exception.FullSetException;
import pro.sky.java.course2.examinerservice.model.Question;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl out;
    public final Question QUESTION_1 = new Question(
            "Вопрос1",
            "Ответ1"
    );
    public final Question QUESTION_2 = new Question(
            "Вопрос2",
            "Ответ2"
    );
    public final Question QUESTION_3 = new Question(
            "Вопрос3",
            "Ответ3"
    );
    public final Question QUESTION_4 = new Question(
            "Вопрос4",
            "Ответ4"
    );
    public final Question QUESTION_5 = new Question(
            "Вопрос5",
            "Ответ5"
    );
    public final Question QUESTION_6 = new Question(
            "Вопрос6",
            "Ответ6"
    );

    @Test
    public void correctlyGetQuestionsTest() {
        when(questionService.size()).thenReturn(6);
        assertThrows(FullSetException.class, () -> out.getQuestions(7));
    }
}