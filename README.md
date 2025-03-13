# AugGPT - Automatic Unit Test Generation Tool

This is an implementation of the paper:
Automatic Unit Test Generation for Programming Assignments
Using Large Language Models. Check [README-Test.md](README-Test.md)
directly if you want to regenerate the paper's result.

## Prerequisite

Java >= 11 and <= 17

Openai-compatible API or Ollama deployment.

## About OpenAI-Compatible API

You need to fill the `base_url` and `APIKey` according to the LLM provider you pick.

For example, the URL for OpenAI GPT (e.g., GPT-4o-mini) is `https://api.openai.com/v1`

for DeepSeek, is `https://api.deepseek.com/v1`,

for QWen, is `https://dashscope.aliyuncs.com/compatible-mode/v1`,...

Just pick whichever you like.

If using

## Quick Start (Docker, CLI)

You can launch the program using docker, passing the necessary arguments in command line.

```shell
docker run -it ... ...
# example (openai compatible api)
TODO
# example (ollama)
TODO
```

## Quick Start (Local, UI)

TODO

## Quick Start (Local, CLI)

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

## TODO

- [x] Migrate the chatgpt api to Langchain4j.
- [ ] UI.

## Others

### About demo in docker

We considered using qtjambi to develop the frontend, so that one may access the web ui
in the container from the host, but unfortunately QT seemed has strange bug when 
continuously appending new text to the textfield, which was required when showing logs. 
So we turned to JavaFX.

The problem seems come from the thread management issue, which significantly 
complicated the development, and we didn't want to spend too much time on such minor feature.

## Reference

This implementation uses LangChain4j to call APIs in a unified style:

https://github.com/langchain4j/langchain4j
