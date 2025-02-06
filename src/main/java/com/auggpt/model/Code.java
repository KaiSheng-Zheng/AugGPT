package com.auggpt.model;

public enum Code {

    SUCCESS(2000,"Everything is good."),
    EVALUATION_PASS(2001,"Test evaluation is passed"),
    EVALUATION_ERROR(4000,"Test evaluation error."),
    EVALUATION_ANALYZE_ERROR(4001,"Test evaluation error during analyzing result"),
    EVALUATION_IO_WRITING_ERROR(4002,"Test evaluation error during writing files"),
    EVALUATION_COMPILE_ERROR(4003, "Test evaluation error during compiling .java file"),
    WORSE_COVERAGE_INSTRUCTION(5001,"The instruction coverage is worse than threshold"),
    WORSE_COVERAGE_BRANCH(5002,"The branch coverage is worse than threshold"),
    WORSE_COVERAGE_LINE(5003,"The line coverage is worse than threshold"),
    WORSE_COVERAGE_METHOD(5004,"The method coverage is worse than threshold"),
    WORSE_COVERAGE_COMPLEXITY(5005,"The complexity coverage is worse than threshold"),
    WORSE_COVERAGE_MUTATION(5101,"The mutation rate is worse than threshold"),
    WORSE_MUTATION_TEST_STRENGTH(5102,"The test strength is at least 20% worse than threshold")

    ;

    Code(int code, String msg) {
    }
}
