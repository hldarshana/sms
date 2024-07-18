package com.example.sms.exception;

import com.example.sms.shared.model.ApiResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class AppExceptionHandler {

    Logger logger = LoggerFactory.getLogger(AppExceptionHandler.class);

    /**
     * This will handle the service level validations and send error response
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value={ResponseStatusException.class})
    public ResponseEntity<Object> handleResponseStatusException(ResponseStatusException ex, WebRequest request){
        logger.error("Validation exception occurred", ex);
        ApiResponse<Exception> apiResponse = new ApiResponse<>(null, ex.getStatusCode().value(),
                ex.getStatusCode().toString(),
                List.of(Objects.requireNonNull(ex.getReason())));
        return new ResponseEntity<>(apiResponse, new HttpHeaders(), ex.getStatusCode().value());
    }

    /**
     * This will handle the dto level validations when coming from request body
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value={ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request){
        logger.error("Validation exception occurred", ex);
        List<String> errors = ex.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .toList();

        ApiResponse<Exception> apiResponse = new ApiResponse<>(null, 400,
                HttpStatusCode.valueOf(400).toString(),
                errors);
        return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatusCode.valueOf(400));
    }

    /**
     * This will handle other common exceptions
     * @param ex
     * @param request
     * @return
     */
    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<Object> handleCommonException(Exception ex, WebRequest request){
        logger.error("Exception occurred", ex);
        ApiResponse<Exception> apiResponse = new ApiResponse<>(null, 500,
                HttpStatusCode.valueOf(500).toString(),
                List.of("Internal Server Error"));
        return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatusCode.valueOf(500));
    }
}
