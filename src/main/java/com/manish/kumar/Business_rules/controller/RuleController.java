package com.manish.kumar.Business_rules.controller;


import com.manish.kumar.Business_rules.model.Rule;
import com.manish.kumar.Business_rules.repository.RuleRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RuleController {
    private final RuleRepository repository;

    public RuleController(RuleRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/v1/rules")
    public String saveRule(@RequestBody Rule rule){
        Rule rule1 = repository.save(rule);
        return rule1.toString();
    }
    @GetMapping("/v1/rules")
    public List<Rule> getAll(){
        return repository.findAll().stream().toList();
    }
}
