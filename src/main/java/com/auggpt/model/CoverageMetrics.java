package com.auggpt.model;

public enum CoverageMetrics {
    INSTRUCTION("instructions"),BRANCH("branches");
    final String name;

    CoverageMetrics(String name){
        this.name = name;
    }
}
