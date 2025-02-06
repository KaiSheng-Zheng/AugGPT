# AugGPT - Automatic Unit Test Generation Tool

This is an implementation of the paper: 
Automatic Unit Test Generation for Programming Assignments 
Using Large Language Models. This document provides guidance to 
regenerate some paper's result.

## Test

### Dataset

To regenerate the paper's quantitative result, you first need to [download the dataset]() 
and extract it under the root of the repo:

```text
AugGPT
|
|-- dataset
|-- data
|-- src
...
```

### Run

Then you may run the test under the directory [src/test/java/com/auggpt](src%2Ftest%2Fjava%2Fcom%2Fauggpt)

[CalculateAML.java](src%2Ftest%2Fjava%2Fcom%2Fauggpt%2FCalculateAML.java)
will calculate the average logical lines per method of the test suite for each approach. 
The result will be printed on the console.

[CaseStudyResult.java](src%2Ftest%2Fjava%2Fcom%2Fauggpt%2FCaseStudyResult.java)
will compare the test suite's running result on submissions of six assignments, 
and categorize the submissions into four types: passed/failed on two test suite, 
failed only on AugGPT's test suite, and failed only on human's test suite.
The result will be dumped to an output directory under [dataset/submissions](dataset%2Fsubmissions).

[EfficiencyTest.java](src%2Ftest%2Fjava%2Fcom%2Fauggpt%2FEfficiencyTest.java) 
will run mutation and coverage test on the test suites through the tool [PITest](https://pitest.org/).
If run successfully, the result will be printed on the console, 
and stored under [data/PITReport](data/PITReport)
