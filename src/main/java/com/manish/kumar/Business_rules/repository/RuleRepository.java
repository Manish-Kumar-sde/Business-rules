package com.manish.kumar.Business_rules.repository;

import com.manish.kumar.Business_rules.model.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleRepository extends JpaRepository<Rule,Integer> {
}
