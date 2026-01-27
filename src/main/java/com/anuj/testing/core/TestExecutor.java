package com.anuj.testing.core;

public class TestExecutor {


    public void execute(TestCase testCase) {
        if (testCase.getId().endsWith("1"))
            testCase.setStatus("PASS");
        else testCase.setStatus("FAIL");
    }
}
