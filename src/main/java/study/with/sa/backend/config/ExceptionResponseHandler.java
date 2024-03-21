package study.with.sa.backend.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.jdi.request.DuplicateRequestException;
import jdk.jfr.Description;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Description("Exception Handlers to customize message and result")
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Description("Bad request exception abort")
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        logger.error("handle MethodArgumentNotValid: {}", e.getMessage());
        ApiResponse<Object> restApiResponse = ApiResponse.error(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(restApiResponse, HttpStatus.BAD_REQUEST);
    }

    @Description("Http message not readable exception abort")
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException e,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        logger.error("handle HttpMessageNotReadable: {}", e.getMessage());
        ApiResponse<Object> restApiResponse = ApiResponse.error(HttpStatus.BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(restApiResponse, HttpStatus.BAD_REQUEST);
    }

    @Description("Request bad request exception abort")
    @ExceptionHandler({HttpClientErrorException.BadRequest.class, HttpClientErrorException.NotFound.class})
    public ApiResponse<Object> handleBadRequestException(Exception e) {
        logger.error("handle BadRequestException: {}", e.getMessage());
        return ApiResponse.error(HttpStatus.BAD_REQUEST, e.getMessage());
    }

    @Description("Method not allowed exception abort")
    public ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                                         HttpHeaders headers,
                                                                         HttpStatus status,
                                                                         WebRequest request) {
        logger.error("handle HttpRequestMethodNotSupported: {}", e.getMessage());
        ApiResponse<Object> restApiResponse = ApiResponse.error(HttpStatus.FORBIDDEN, e.getMessage());
        return new ResponseEntity<>(restApiResponse, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Description("Exception abort")
    @ExceptionHandler({RuntimeException.class, InterruptedException.class, InternalError.class,
            JsonProcessingException.class, JSONException.class, IOException.class,
            TimeoutException.class, DuplicateRequestException.class})
    public ApiResponse<Object> handleException(Exception e) {
        logger.error("handle Exception: {}", e.getMessage());
        return ApiResponse.error(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    @Description("Request unauthorized exception abort")
    @ExceptionHandler({HttpClientErrorException.Unauthorized.class})
    public ApiResponse<Object> handleUnauthorizedException(Exception e) {
        logger.error("handle UnauthorizedException: {}", e.getMessage());
        return ApiResponse.error(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    @Description("Request forbidden exception abort")
    @ExceptionHandler({HttpClientErrorException.Forbidden.class, HttpClientErrorException.NotAcceptable.class})
    public ApiResponse<Object> handleForbiddenException(Exception e) {
        logger.error("handle ForbiddenException: {}", e.getMessage());
        return ApiResponse.error(HttpStatus.FORBIDDEN, e.getMessage());
    }
}