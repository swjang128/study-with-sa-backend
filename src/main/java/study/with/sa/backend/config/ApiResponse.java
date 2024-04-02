package study.with.sa.backend.config;

import jdk.jfr.Description;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiResponse {
    private int status;
    private String message;
    private Object data;

    @Description("Setting up API response without data")
    public static ApiResponse ok() {
        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        return response;
    }

    @Description("Setting up API response with data")
    public static ApiResponse success(Object data) {
        ApiResponse response = new ApiResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.getReasonPhrase());
        response.setData(data);
        return response;
    }

    @Description("Setting up API response when error occurred")
    public static ApiResponse error(HttpStatus status, String message) {
        ApiResponse response = new ApiResponse();
        response.setStatus(status.value());
        response.setMessage(message);
        return response;
    }
}