package com.manish.kumar.Business_rules.exception;


import com.manish.kumar.Business_rules.dto.BadRequestErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(RequiredFieldMissingException.class)
    public ResponseEntity<BadRequestErrorResponse> requiredFieldMissingException(RequiredFieldMissingException exc, WebRequest request) {
        return new ResponseEntity<BadRequestErrorResponse>(new BadRequestErrorResponse(exc.getCode(), exc.getErrorMessage(), exc.getMissingFields()), HttpStatus.BAD_REQUEST);
    }
}
