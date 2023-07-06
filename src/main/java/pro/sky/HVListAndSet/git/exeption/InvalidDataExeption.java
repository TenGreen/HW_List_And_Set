package pro.sky.HVListAndSet.git.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataExeption extends RuntimeException{
    public InvalidDataExeption() {
    }

    public InvalidDataExeption(String message) {
        super(message);
    }

    public InvalidDataExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataExeption(Throwable cause) {
        super(cause);
    }

    public InvalidDataExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
