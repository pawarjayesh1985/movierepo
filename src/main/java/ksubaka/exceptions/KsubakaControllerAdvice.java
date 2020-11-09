package ksubaka.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jpawar on 11/9/2020.
 */
@ControllerAdvice
public class KsubakaControllerAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(KsubakaControllerAdvice.class);
    private static final String APPLICATION_EXCEPTION_MSG = "Returning BAD_REQUEST : ";


    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String processException(Exception ex) {
        logExceptionWithErrorDTO(APPLICATION_EXCEPTION_MSG, ex.getMessage());
        return ex.getMessage();
    }


    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String processException(KsubakaBaseException ksubakaKnowExceptions) {
        logExceptionWithErrorDTO(APPLICATION_EXCEPTION_MSG, ksubakaKnowExceptions.getMessage());
        return ksubakaKnowExceptions.getMessage();
    }


    private void logExceptionWithErrorDTO(String base, String optionalMessage) {
        if (optionalMessage != null) {
            LOGGER.error(base + optionalMessage );
        } else {
            LOGGER.error(base );
        }
    }
}
