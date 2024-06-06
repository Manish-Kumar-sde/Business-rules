package com.manish.kumar.Business_rules.controller;

import com.manish.kumar.Business_rules.model.Variable;
import com.manish.kumar.Business_rules.repository.VariableRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VariableController {
    private final VariableRepository variableRepository;

    public VariableController(VariableRepository variableRepository) {
        this.variableRepository = variableRepository;
    }

    @RequestMapping("/v1/variable")
    public Variable saveVariable(@RequestBody Variable variable) {
        return variableRepository.save(variable);
    }
}
