package ksubaka.failures;

import ksubaka.exceptions.MovieNotFoundException;
import ksubaka.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * This class should be used to predefined error messages.
 * Created by jpawar on 11/9/2020.
 */
@Component
public class PreDefinedErrorMessage {
    private String apiNameIsInvalidMessage = StringUtils.EMPTY;

    public String getAPINameIsInvalidMessage() {
        if(StringUtils.isBlank(apiNameIsInvalidMessage)
                || !(apiNameIsInvalidMessage.contains(ErrorConstants.API_NAME_INVALID))) {
            //This key will be in order to show some error localization message on UI.
            ErrorMessage apiNameInvalid = new ErrorMessage();
            apiNameInvalid.setKey(ErrorConstants.API_NAME_INVALID);
            apiNameInvalid.setMessage("API Name is Invalid");
            apiNameIsInvalidMessage =  JsonUtils.getInstance().writeValueAsString(apiNameInvalid);

        }
        return apiNameIsInvalidMessage;
    }

    public String movieNotFoundMessage(String movieTitle) {
        ErrorMessage movieNotFound = new ErrorMessage();
        movieNotFound.setKey(ErrorConstants.MOVIE_NOT_FOUND);
        movieNotFound.setMessage(String.format("Movie %s Not Found", movieTitle));
        throw new MovieNotFoundException(JsonUtils.getInstance().writeValueAsString(movieNotFound));
    }
}
