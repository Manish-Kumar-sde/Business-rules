package com.manish.kumar.Business_rules.controller;


import com.manish.kumar.Business_rules.exception.RequiredFieldMissingException;
import com.manish.kumar.Business_rules.model.Product;
import com.manish.kumar.Business_rules.repository.ProductRepository;
import com.manish.kumar.Business_rules.service.RuleEvaluationService;
import com.manish.kumar.Business_rules.util.Validator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RuleEvaluationController {
    private final ProductRepository productRepository;
    private final RuleEvaluationService ruleEvaluationService;

    public RuleEvaluationController(ProductRepository productRepository, RuleEvaluationService ruleEvaluationService) {
        this.productRepository = productRepository;
        this.ruleEvaluationService = ruleEvaluationService;
    }

    @PostMapping("/v1/rule-evaluate/{product_id}")
    public Map<String, String> ruleEvaluation(@PathVariable Integer product_id, @RequestBody Map<String, Object> variables) throws RequiredFieldMissingException {
        Product product = productRepository.findById(product_id).orElse(new Product());
        if (Validator.validateVariables(product.getVariables(), variables)) {
            System.out.println(variables.toString());
            return ruleEvaluationService.evaluateRules(product.getRules(), variables);
        } else {
            return new HashMap<>();
        }
    }
}
