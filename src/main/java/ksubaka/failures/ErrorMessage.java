package ksubaka.failures;

/**
 * Created by jpawar on 11/9/2020.
 */
public class ErrorMessage {
    //This key will be in order to show some error localization message on UI.
    private String key;
    private String message;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
