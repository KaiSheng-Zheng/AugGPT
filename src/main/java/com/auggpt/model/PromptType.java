package com.auggpt.model;

public enum PromptType {


    GENERAL_AGENT_SET(100,"You are a computer science coder, it's <DATE> now.\n" +
            "# Character\n" +
            "As a computer science professional coder, you excel at computer programming, problem-solving, and assignment designing. You also have an extensive knowledge base helping you to finish tasks. " +
            "You can provide an elegant and well-designed test suit with a deep understanding of the assignment document.\n" +
            "## Skills\n" +
            "### Assignment analysis and understanding\n" +
            "- Understand the provided assignment thoroughly including requirements, rules, limitations, instructions, and codes.\n" +
            "- Identify and understand those calculation/implementation requirements specified in the document.\n" +
            "### Unit test writing\n" +
            "- Write unit test code implementation following the user's instruction. You will write all code out in detail without any skipping.\n" +
            "### Information understanding\n" +
            "- Able to understand and utilize provided information to write tests.\n" +
            "- Able to understand and utilize the coverage test result to discover and test untested methods and cases.\n" +
            "- Able to read and understand the compilation log to avoid writing erroneous code.\n" +
            "## Personality\n" +
            "- Exhibit a relentless and unfaltering commitment to fulfilling objectives.\n" +
            "- Focusing on tasks, and following instructions.\n" +
            "- Try one's best to fulfill the task without skipping."),
    RAW_AGENT_SET(100,"You are a helpful assistant."), //https://arxiv.org/html/2407.11969v1#bib.bib34
    GENERAL_GET_CODE(6, "Now, please generate a complete test suite with the help of previous information and the related field knowledge you have already fully mastered. This is a hard task, put all effort into it!\n" +
            "\n" +
            "There are some key points for you to pay attention to: \n" +
            "0. PAY ATTENTION ON THE CORRECTNESS with the help of the content in the document.\n" +
            "1. Use Junit5, especially org.junit.jupiter.api.Assertions. Do NOT use @BeforeEach, global variables or helper methods.\n" +
            "2. Do NOT use any method NOT MENTIONED in the documents when testing.\n" +
            "3. ALWAYS use REFLECTION to access PRIVATE fields.\n" +
            "4. You MUST generate at least 4 tests.\n" +
            "5. Each test MUST contain COMPLEX logic with COMPOSITE method call chains, with at least 8 lines each, covering a wide range of methods and classes.\n" +
            "6. Focus on the COMPLEX LOGIC TEST. The LOGIC should be completely based on the description of the document. Test as many methods and classes as possible. Try to test the boundary case.\n" +
            "7. Use detailed comments to derive the test logic and write the complex test step by step.\n" +
            "8. You MUST put all tests in a single class, with @Test public void.\n" +
            "9. ONLY show me the implementation, NO extra words. Wrap the code with markdown code block.\n"),

    CODE_SUMMARY(7, "As a Java unit test professor, please help me find out what methods and cases are tested in the provided test suite." +
            "\n" +
            "[REPLACE_0]\n" +
            "\n" +
            "This is the end of code. Now return a well documented list to describe what classes and methods has been tested. ONLY return the list."),
    RAW_PDF_SUBMIT(8, "As a Java unit test professor, I need you to help me with the generation of some important Java unit tests, which is for an assignment. Below is the PDF content of an assignment, please understand the content and prepare for the upcoming test.\n" +
            "\n" +
            "[REPLACE_0]\n" +
            "\n" +
            "This is the end of the document. Now you need to return the brief introductions of the classes and methods in a well-organized list. Keeping the completeness of important information. The final goal is to guide someone who has not read the original document to write a unit test suite based on the list summary. Starting your response with: Here is the list summary of the original documents:"),
    PDF_SUMMARY_SUBMIT(9, "As a professional Java unit test professor, please help me to generate a unit test suite based on an assignment. Here is the description of the assignment. You may understand it completely and prepare for upcoming tasks.\n" +
            "\n" +
            "[REPLACE_0]\n" +
            "\n" +
            "This is the end of the description. Return a small list to conclude the requirements, rules, details that are easy to missed mentioned in the document. Only return the list, keep it short and tidy."),
    REFINE_GET_CODE(10, "This is a piece of coverage test result, which provides information about what method needs more tests. Pay attention to those lines marked 'NOT COVERED' and 'PARTLY COVERED' require more tests, and leverage the information in the code.\n" +
            "Coverage information:\n" +
            "[REPLACE_0]\n" +
            "\n" +
            "This is a piece of mutation test result, providing information about survived and uncovered mutants and corresponding methods.\n" +
            "Mutation test information:\n" +
            "[REPLACE_1]\n" +
            "\n" +
            "This is a piece of compilation error log, providing information about previous compilation errors.\n" +
            "Compilation ERROR log:\n" +
            "[REPLACE_2]\n" +
            "\n" +
            "Now, please generate a complete test suite with the help of the document and related field knowledge. Utilize the coverage information, mutation test result, and the compilation error log. This is a hard task, put all effort into it!\n" +
            "\n" +
            "There are some key points for you to pay attention to: \n" +
            "0. Do NOT use ANY method NOT PRESENTED in the DOCUMENT, which will cause compilation error. Try to test without using it.\n" +
            "1. Try to test the PARTLY COVERED and UNCOVERED lines provided in coverage information.\n" +
            "2. PAY ATTENTION ON THE CORRECTNESS with the help of the document and general knowledge.\n" +
            "3. Use Junit5, especially org.junit.jupiter.api.Assertions. Do NOT use @BeforeEach or global variables. Do NOT use List.of(). Try to test through calling public methods.\n" +
            "4. Do NOT use getter/setter, instead, use REFLECTION to access PRIVATE fields if getter/setter are not provided in the document. Pay attention to whether the data type is object or primitive and whether the method/field is defined in its superclass or its class.\n" +
            "5. MUST generate at least 4 tests.\n" +
            "6. Each test MUST contain COMPLEX logic with COMPOSITE method call chains, with at least 8 lines each, covering a wide range of methods, classes and cases.\n" +
            "7. Focus on the COMPLEX LOGIC TEST. The LOGIC should be completely based on the description of the document. The test should FOCUS on the COVERAGE INFORMATION to cover more cases.\n" +
            "8. Use detailed comments to derive the test logic step by step and write down the process before the corresponding instruction. The assertion result should be derived from the document.\n" +
            "9. You MUST put all tests in a single class, with @Test public void.\n" +
            "10. ONLY show me the implementation, NO extra words. Wrap the code with a markdown code block.\n" +
            "Note from user: pay attention to the method names, only 'generateStudentGroupSize, standardizedScores, generatePersonalScore' are implemented for GradeSystem, 'calculatePersonalScore' for Student.\n" +
            "Take a deep breath and start."),

    REFINE_GET_CODE_USR(11, "This is a piece of coverage test result, which provides information about what method needs more tests. Pay attention to those lines marked 'NOT COVERED' and 'PARTLY COVERED' require more tests, and leverage the information in the code.\n" +
            "Coverage information:\n" +
            "[REPLACE_0]\n" +
            "\n" +
            "This is a piece of mutation test result, providing information about survived and uncovered mutants and corresponding methods.\n" +
            "Mutation test information:\n" +
            "[REPLACE_1]\n" +
            "\n" +
            "This is a piece of compilation error log, providing information about previous compilation errors.\n" +
            "Compilation ERROR log:\n" +
            "[REPLACE_2]\n" +
            "\n" +
            "Now, please generate a complete test suite with the help of the document and related field knowledge. Utilize the coverage information, mutation test result, and the compilation error log. This is a hard task, put all effort into it!\n" +
            "\n" +
            "There are some key points for you to pay attention to: \n" +
            "0. Do NOT use ANY method NOT PRESENTED in the DOCUMENT, which will cause compilation error. Try to test without using it.\n" +
            "1. Try to test the PARTLY COVERED and UNCOVERED lines provided in coverage information.\n" +
            "2. PAY ATTENTION ON THE CORRECTNESS with the help of the document and general knowledge.\n" +
            "3. Use Junit5, especially org.junit.jupiter.api.Assertions. Do NOT use @BeforeEach or global variables. Do NOT use List.of(). Try to test through calling public methods.\n" +
            "4. Do NOT use getter/setter, instead, use REFLECTION to access PRIVATE fields if getter/setter are not provided in the document. Pay attention to whether the data type is object or primitive and whether the method/field is defined in its superclass or its class.\n" +
            "5. MUST generate at least 4 tests.\n" +
            "6. Each test MUST contain COMPLEX logic with COMPOSITE method call chains, with at least 8 lines each, covering a wide range of methods, classes and cases.\n" +
            "7. Focus on the COMPLEX LOGIC TEST. The LOGIC should be completely based on the description of the document. The test should FOCUS on the COVERAGE INFORMATION to cover more cases.\n" +
            "8. Use detailed comments to derive the test logic step by step and write down the process before the corresponding instruction. The assertion result should be derived from the document.\n" +
            "9. You MUST put all tests in a single class, with @Test public void.\n" +
            "10. ONLY show me the implementation, NO extra words. Wrap the code with a markdown code block.\n" +
            "Note from user: I want to focus on the test of multiple turns in a game using 'public void nextTurn(int step, int cost)'\n" +
            "Take a deep breath and start."),

    PLAIN_GET_CODE(11, "This is a piece of the student's Java program code, please generate a single set of unit tests based on it.\n" +
            "[REPLACE_0]\n"),
    PLAIN_REFINE(12, "Please refine the test and generate a new set of unit tests.");

    private final int code;
    private final String prompt;
    PromptType(int code, String prompt) {
        this.code =
                code;
        this.prompt = prompt;
    }
    public int getCode() {
        return this.code;
    }
    public String getPrompt(){
        return this.prompt;
    }


}
