package com.anuj.testing.core;

public class TestExecutor implements TestExecutable{



    @Override
    public void execute(TestCase testCase) {
        if (testCase.getId().endsWith("1"))
            testCase.setStatus(TestStatus.PASS);
        else testCase.setStatus(TestStatus.FAIL);

    }
}
