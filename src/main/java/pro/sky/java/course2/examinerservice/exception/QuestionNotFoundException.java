package pro.sky.java.course2.examinerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException() {
    }
    public QuestionNotFoundException(String message) {
        super(message);
    }
}
