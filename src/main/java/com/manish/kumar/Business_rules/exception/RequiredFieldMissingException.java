package com.manish.kumar.Business_rules.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class RequiredFieldMissingException extends Exception {
    private final String code;
    private final String errorMessage;
    private final List<String> missingFields;

    public RequiredFieldMissingException(String code, String errorMessage, List<String> missingFields) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.missingFields = missingFields;
    }
}
