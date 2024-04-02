package study.with.sa.backend.config;

import jdk.jfr.Description;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter // 응답 결과를 JSON 객체로 만들어주기 위해서 필요!
@Builder
public class ApiResponse {
    private int status;
    private String message;
    private Object data;

    @Description("Setting up API response without data")
    public static ApiResponse ok() {
        return ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .build();
    }

    @Description("Setting up API response with data")
    public static ApiResponse success(Object data) {
        return ApiResponse.builder()
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(data)
                .build();
    }

    @Description("Setting up API response when error occurred")
    public static ApiResponse error(HttpStatus status, String message) {
        return ApiResponse.builder()
                .status(status.value())
                .message(message)
                .build();
    }
}