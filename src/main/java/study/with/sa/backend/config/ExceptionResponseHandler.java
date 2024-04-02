package study.with.sa.backend.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.jdi.request.DuplicateRequestException;
import jdk.jfr.Description;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Description("Exception Handlers to customize message and result")
@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {
    @Description("Request bad request exception abort")
    @ExceptionHandler({HttpClientErrorException.BadRequest.class,
            HttpClientErrorException.NotFound.class,
            HttpClientErrorException.MethodNotAllowed.class})
    public ApiResponse handleBadRequestException(Exception e) {
        log.error("handle BadRequestException: {}", e.getMessage());
        return ApiResponse.error(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @Description("Exception abort")
    @ExceptionHandler({RuntimeException.class, InterruptedException.class, InternalError.class,
            JsonProcessingException.class, JSONException.class, IOException.class,
            TimeoutException.class, DuplicateRequestException.class})
    public ApiResponse handleException(Exception e) {
        log.error("handle Exception: {}", e.getMessage());
        return ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @Description("Request unauthorized exception abort")
    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    public ApiResponse handleUnauthorizedException(HttpClientErrorException e) {
        log.error("handle UnauthorizedException: {}", e.getMessage());
        return ApiResponse.error(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @Description("Request forbidden exception abort")
    @ExceptionHandler({HttpClientErrorException.Forbidden.class, HttpClientErrorException.NotAcceptable.class})
    public ApiResponse handleForbiddenException(HttpClientErrorException e) {
        log.error("handle ForbiddenException: {}", e.getMessage());
        return ApiResponse.error(HttpStatus.FORBIDDEN, e.getMessage());
    }
}