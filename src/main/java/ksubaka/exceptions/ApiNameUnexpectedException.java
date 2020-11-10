package ksubaka.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jpawar on 11/9/2020.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ApiNameUnexpectedException extends KsubakaBaseException {
    public ApiNameUnexpectedException(String message){
        super(message);
    }
}
