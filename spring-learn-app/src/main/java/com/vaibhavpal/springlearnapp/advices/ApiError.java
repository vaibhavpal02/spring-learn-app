package com.vaibhavpal.springlearnapp.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ApiError {
 private HttpStatus status;
 private String message;
}
