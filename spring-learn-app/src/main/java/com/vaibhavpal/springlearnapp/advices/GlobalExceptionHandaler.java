package com.vaibhavpal.springlearnapp.advices;

import com.vaibhavpal.springlearnapp.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandaler
{
    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ApiError> handleResourcenotfound(ResourceNotFoundException exception)
//    {
//        ApiError apiError= ApiError.builder().
//                status(HttpStatus.NOT_FOUND).
//                message(exception.getMessage())
//                .build();
//
//        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
//    }

    public ResponseEntity<ApiResponse<?>> handleResourcenotfound(ResourceNotFoundException exception)
    {
        ApiError apiError= ApiError.builder().
                status(HttpStatus.NOT_FOUND).
                message(exception.getMessage())
                .build();

        return buildErrorResponseEntity(apiError);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<?>> handleValidationErrors(MethodArgumentNotValidException ex) {

        String errorMsg = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .findFirst()
                .orElse("Invalid input");

        ApiError apiError = ApiError.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(errorMsg)
                .build();

        return new ResponseEntity<>(new ApiResponse<>(apiError), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ApiResponse<?>> buildErrorResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
    }
}
