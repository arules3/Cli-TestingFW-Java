package com.anuj.testing.core.cli;

import com.anuj.testing.core.*;

import java.util.*;

public class TestManagerApp {



    private static void addTestCase(Scanner scanner, TestRepository testRepository) {
        System.out.println("Enter Test id");
        String id = scanner.nextLine();
        System.out.println("Enter Title");
        String title = scanner.nextLine();
        System.out.println("Enter Steps");
        String steps = scanner.nextLine();
        System.out.println("Enter Expected Result");
        String expectedResult = scanner.nextLine();

        testRepository.add(new TestCase(id, title , steps, expectedResult));

    }

    private static void executeAllTests(TestRepository repository, TestExecutable executor) {
        Map<String, TestCase> testcases = repository.getAll();

        if(testcases.isEmpty()) {
            System.out.println("No Tests to execute , exiting..");
            return;
        }
        for(TestCase testCase : testcases.values()) {
            executor.execute(testCase);

        }

    }

    private static Map<TestStatus, List<TestCase>> groupTestsByStatus(TestRepository repository) {
        Map<TestStatus, List<TestCase>> testsByStatus = new HashMap<>();

        for (Map.Entry<String, TestCase> entry : repository.getAll().entrySet()) {
            TestStatus status = entry.getValue().getStatus();
            testsByStatus
                    .computeIfAbsent(status, k -> new ArrayList<>())
                    .add(entry.getValue());
        }

        return testsByStatus;


    }


    private static void printSummary(Map<TestStatus ,List<TestCase>> testsByStatus) {

        if (testsByStatus.isEmpty()) {
            System.out.println("No execution data available");
            return;
        }

        System.out.println("\n===== EXECUTION SUMMARY =====");
        for(Map.Entry<TestStatus, List<TestCase>> entry : testsByStatus.entrySet()) {
            TestStatus status = entry.getKey();
            List<TestCase> tests = entry.getValue();

            System.out.println(status + " : " + tests.size());

            for (TestCase test : tests) {
                test.printSummary();
            }

        }

    }

    private  static void printMenu () {
        System.out.println("""
                HERE ARE YOUR OPTIONS\s
                1) Add Testcase\s
                2) Execute Testcases\s
                3) Show Execution Summary
                4) EXIT""");

    }




    public static void main(String[] args) {

        TestRepository repository = new TestRepository();
        TestExecutable executor = new TestExecutor();
        TestExecutable mock = testCase -> {
            TestStatus status =testCase.getStatus();
            System.out.println(status);
        };


        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());


            switch (choice) {
                case 1 -> addTestCase(scanner, repository);
                case 2 -> executeAllTests(repository, executor);
                case 3 -> printSummary(groupTestsByStatus(repository));
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
        }

    }


}
