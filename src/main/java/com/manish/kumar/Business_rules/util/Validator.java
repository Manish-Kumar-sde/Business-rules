package com.manish.kumar.Business_rules.util;

import com.manish.kumar.Business_rules.exception.RequiredFieldMissingException;
import com.manish.kumar.Business_rules.model.Variable;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Slf4j
public class Validator {
    public static boolean validateVariables(List<Variable> variables, Map<String, Object> request) throws RequiredFieldMissingException {
        List<String> missingFields = new ArrayList<>();
        for (Variable variable : variables) {
            String name = variable.getName();
            String varType = variable.getType();
            boolean required = variable.isRequired();

            // check if required field is present

            if (required && !request.containsKey(name)) {
                missingFields.add(name);
            }

        }
        if (!missingFields.isEmpty()) {
            throw new RequiredFieldMissingException("MRF-01", "Required field is missing", missingFields);
        }
        return true;
    }
}
