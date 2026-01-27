package com.anuj.testing.core;

public class TestCase {
    private  String title;
    private  String id ;
    private  String status;
    private String steps;
    private String expectedResult;


    public TestCase(String title , String id , String status ) {
        this.id = id;
        this.title = title;
        this.status = "NOT EXECUTED";

    }

    public TestCase(String title , String id , String steps , String expectedResult) {
        this.id = id;
        this.title = title;
        this.status = "NOT EXECUTED";

    }


    public String getId(){
        return  this.id;
    }

    public String getTitle() {
        return  this.title;
    }

    public String getStatus() {
        return  this.status;
    }


    public void setStatus( String status) {

        if(status == null || status.isEmpty()) {
            System.out.println("Update Ignored , No Status Info");
            return;
        }

        this.status = status;

    }


    public boolean isPassed() {
        return  "PASS".equals(status);
    }

    public boolean isFailed() {
        return "FAIL".equals(status);
    }

    public void printSummary() {
        String result = isPassed() ? "PASS" : "NOT PASSED";
        System.out.println("[" + id + "] " + title + " => " + result);
    }



}
