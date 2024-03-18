package study.with.sa.backend.config;

import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestApiResponse<T> {
    private int status;
    private String message;
    private T data;

    @Description("Setting up Rest API response without data")
    public static <T> RestApiResponse<T> success() {
        RestApiResponse<T> response = new RestApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return response;
    }

    @Description("Setting up Rest API response with data")
    public static <T> RestApiResponse<T> success(T data) {
        RestApiResponse<T> response = new RestApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        response.setData(data);
        return response;
    }

    @Description("Setting up Rest API response when error occurred")
    public static <T> RestApiResponse<T> error(HttpStatus status, String message) {
        RestApiResponse<T> response = new RestApiResponse<>();
        response.setStatus(status.value());
        response.setMessage(message);
        return response;
    }
}