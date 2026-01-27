package com.anuj.testing.core;

import java.util.HashMap;
import java.util.Map;

public class TestRepository {
    private  final Map<String , TestCase> testCases = new HashMap<>();

    public void add(TestCase testCase) {
         testCases.put(testCase.getId() , testCase);
    }


    public TestCase getTestCaseById(String id) {
        return  testCases.get(id);

    }

    public Map <String ,TestCase> getAll() {
        return  new HashMap<>(testCases) ;

    }

}
