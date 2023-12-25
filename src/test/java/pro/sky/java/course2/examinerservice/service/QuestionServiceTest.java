package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.examinerservice.exception.QuestionNotFoundException;
import pro.sky.java.course2.examinerservice.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QuestionServiceTest {
    QuestionService out = new JavaQuestionService(new ArrayList<>());

    public static Stream<Arguments> provideParamsForTest() {
        return Stream.of(
                Arguments.of("Вопрос1", "Ответ1"),
                Arguments.of("Вопрос2", "Ответ2"),
                Arguments.of("Вопрос3", "Вопрос3")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void addCorrectlyQuestionsTest(String question, String answer) {
        out.add(question, answer);
        Question question1 = new Question(question, answer);
        assertTrue(out.getAll().contains(question1));
    }

    @Test
    void addNegativeTest() {
        out.add("Вопрос3", "Ответ3");
        assertThrows(IllegalArgumentException.class,
                () -> out.add("Вопрос3", "Ответ3")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void removeCorrectlyQuestionsTest(String question, String answer) {
        out.add(question, answer);
        Question question1 = new Question(question, answer);
        assertEquals(out.remove(question1), question1);
        assertThrows(QuestionNotFoundException.class, () ->
                out.find(question));

    }

    @Test
    void findCorrectlyQuestionsTest() {
        out.add("Вопрос1", "Ответ1");
        Question actual = new Question("Вопрос1", "Ответ1");
        assertEquals(out.find("Вопрос1"),
                actual);
    }

    @Test
    void findNegativeTest() {
        out.add("Вопрос3", "Ответ3");
        assertThrows(QuestionNotFoundException.class,
                () -> out.find("Вопрос2")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTest")
    void getAllCorrectlyQuestionsTest(String question, String answer) {
        out.add(question, answer);
        Question question1 = new Question(question, answer);
        assertTrue(out.getAll().contains(question1));
        assertEquals(out.getAll().size(), 1);

    }
}