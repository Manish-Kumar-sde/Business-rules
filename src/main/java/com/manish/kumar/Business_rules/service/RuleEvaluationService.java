package com.manish.kumar.Business_rules.service;


import com.manish.kumar.Business_rules.model.Rule;
import lombok.extern.slf4j.Slf4j;
import org.mvel2.MVEL;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RuleEvaluationService {
    public Map<String,String> evaluateRules(List<Rule> rules, Map<String, Object> variables){
        Map<String, String> results = new HashMap<>();
        log.info("{}",rules);
        for (Rule rule : rules) {
            String condition = rule.getCondition();
            try {
                String result = MVEL.eval(condition,variables,String.class);
                results.put(rule.getCode(), result);
            }catch (Exception exception){
                log.error("Exception {}", exception.getClass() );
            }

        }
        return results;
    }
}
