package com.anuj.testing.core;

public class TestCase {
    private  String title;
    private  String id ;
    private  TestStatus status;
    private String steps;
    private String expectedResult;


    public TestCase(String title , String id ) {
        this.id = id;
        this.title = title;
        this.status = TestStatus.NOT_EXECUTED;

    }

    public TestCase(String title , String id , String steps , String expectedResult) {
        this.id = id;
        this.title = title;
        this.steps = steps;
        this.expectedResult = expectedResult;

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
