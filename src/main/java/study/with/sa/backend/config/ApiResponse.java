package study.with.sa.backend.config;

import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    @Description("Setting up API response without data")
    public static <T> ApiResponse<T> success() {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return response;
    }

    @Description("Setting up API response with data")
    public static <T> ApiResponse<T> success(T data) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        response.setData(data);
        return response;
    }

    @Description("Setting up API response when error occurred")
    public static <T> ApiResponse<T> error(HttpStatus status, String message) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setStatus(status.value());
        response.setMessage(message);
        return response;
    }
}