package ws.synopsis.training.soap.consumer.exception;

import org.springframework.security.core.AuthenticationException;

public class TrainingAuthException extends AuthenticationException {
    public TrainingAuthException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public TrainingAuthException(String msg) {
        super(msg);
    }
}
