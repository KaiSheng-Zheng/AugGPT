# AugGPT - Automatic Unit Test Generation Tool

<a href="https://doi.org/10.5281/zenodo.14826333"><img src="https://zenodo.org/badge/928230839.svg" alt="DOI"></a>

This is an implementation of the paper:
Automatic Unit Test Generation for Programming Assignments
Using Large Language Models. Check [README-Test.md](README-Test.md)
directly if you want to regenerate the paper's result.

## Prerequisite

Java >= 11 and <= 17

[OpenAI API key](https://platform.openai.com/api-keys)

## Quick Start

### Step 1. Configuration

Change the following path configuration accordingly in the file
./src/main/resources/auggpt.properties
```text
# --------------- Below are General configurations ---------------
pdfInputPath = absolute\\path\\to\\assignment\\pdf
programRootPath = absolute\\path\\to\\source\\program\\directory

repoPath = absolute\\path\\to\\this\\repository\\root
```

### Step 2. Launch

Run AutoTestGeneratorClien.java, input your api key when required.

```shell
java path/to/AutoTestGeneratorClient.java
```

### Step 3. Output

You may check your output under the directory:
./data/GPTTests

Which will be generated after the system's run.
If the system runs correctly, there should be a TestClass.java under the directory,
and at least 4 test methods in the test class.

## Threshold Configurations

Refer to the file ./src/main/resources/auggpt.properties

## Possible Issues

### Compilation Error

1. Check the three path configurations.
2. Check the Java version.

### Send Prompt Failed/Timeout/...

You may want to check the OpenAI's error code [here](https://platform.openai.com/docs/guides/error-codes/api-errors) **first**.

Checklist:

1. the api is correct and available, especially the bill limitation;
2. Check your network;
3. Check the [OpenAI's api service availability](https://status.openai.com/) (and third-party provider if any);

### PITest (mutation test) result output successfully but all metrics are zero

Check the Java version, especially whether exceed Java 17


## Reference

This implementation uses LangChain4j to call APIs in a unified style:

https://github.com/langchain4j/langchain4j
