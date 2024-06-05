package com.manish.kumar.Business_rules.controller;


import com.manish.kumar.Business_rules.model.Product;
import com.manish.kumar.Business_rules.repository.ProductRepository;
import com.manish.kumar.Business_rules.service.RuleEvaluationService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RuleEvaluationController {
    private final ProductRepository productRepository;
    private final RuleEvaluationService ruleEvaluationService;

    public RuleEvaluationController(ProductRepository productRepository, RuleEvaluationService ruleEvaluationService) {
        this.productRepository = productRepository;
        this.ruleEvaluationService = ruleEvaluationService;
    }

    @PostMapping("/v1/rule-evaluat/{product_id}")
    public Map<String,String> ruleEvaluation(@PathVariable Integer product_id, @RequestBody Map<String, Object> variables){
        Product product = productRepository.findById(product_id).orElse(new Product());
        System.out.println(variables.toString());
        return ruleEvaluationService.evaluateRules(product.getRules(),variables);
    }
}
