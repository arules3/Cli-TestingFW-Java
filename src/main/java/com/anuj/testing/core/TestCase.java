package com.anuj.testing.core;

public class TestCase {
    private  final String title;
    private final String id ;
    private  TestStatus status;
    private final  String steps;
    private final String expectedResult;




    public TestCase(String title , String id , String steps , String expectedResult) {
        if(id== null || id.isBlank()) {
            throw new IllegalArgumentException("Test Id cannot be null or empty");
        }
        this.id = id;
        this.title = title;
        this.steps = steps;
        this.expectedResult = expectedResult;
        this.status = TestStatus.NOT_EXECUTED;

    }


    public String getId(){
        return  this.id;
    }

    public String getTitle() {
        return  this.title;
    }

    public TestStatus getStatus() {
        return  this.status;
    }


    public void setStatus(TestStatus status) {

        if (status == null) {
            System.out.println("Update Ignored , No Status Info");
            return;
        }

        this.status = status;

    }


    public boolean isPassed() {
        return  status == TestStatus.PASS;
    }

    public boolean isFailed() {
        return status == TestStatus.FAIL;
    }

    public void printSummary() {
        String result = isPassed() ? "PASS" : "NOT PASSED";
        System.out.println("[" + id + "] " + title + " => " + result);
    }



}
