package com.manish.kumar.Business_rules.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code;
    private String description;
    private String condition;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product product;

    @Override
    public String toString() {
        return "Rule{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
