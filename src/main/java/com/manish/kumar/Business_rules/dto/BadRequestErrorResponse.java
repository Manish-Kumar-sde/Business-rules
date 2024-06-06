package com.manish.kumar.Business_rules.dto;

import java.util.List;

public record BadRequestErrorResponse(
        String code,
        String errorMessage,
        List<String> fields) {
}
