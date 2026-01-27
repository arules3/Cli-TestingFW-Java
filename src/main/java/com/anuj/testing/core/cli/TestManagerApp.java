package com.anuj.testing.core.cli;

import com.anuj.testing.core.TestCase;
import com.anuj.testing.core.TestExecutor;
import com.anuj.testing.core.TestRepository;

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

    private static void executeAllTests(TestRepository repository, TestExecutor executor) {
        Map<String, TestCase> testcases = repository.getAll();

        if(testcases.isEmpty()) {
            System.out.println("No Tests to execute , exiting..");
            return;
        }
        for(TestCase testCase : testcases.values()) {
            executor.execute(testCase);

        }

    }

    private static Map<String , List<TestCase>> groupTestsByStatus(TestRepository repository) {
        Map<String, List<TestCase>> testsByStatus = new HashMap<>();

        for (Map.Entry<String, TestCase> entry : repository.getAll().entrySet()) {
            String status = entry.getValue().getStatus();
            testsByStatus
                    .computeIfAbsent(status, k -> new ArrayList<>())
                    .add(entry.getValue());
        }

        return testsByStatus;


    }


    private static void printSummary(Map<String ,List<TestCase>> testsByStatus) {

        if (testsByStatus.isEmpty()) {
            System.out.println("No execution data available");
            return;
        }

        System.out.println("\n===== EXECUTION SUMMARY =====");
        for(Map.Entry<String, List<TestCase>> entry : testsByStatus.entrySet()) {
            String status = entry.getKey();
            List<TestCase> tests = entry.getValue();

            System.out.println(status + " : " + tests.size());

            for (TestCase test : tests) {
                test.printSummary();
            }

        }

    }

    private  static void printMenu () {
        System.out.println("HERE ARE YOUR OPTIONS \n" +
        "1) Add Testcase \n" + "2) Execute Testcases \n" + "3) Show Execution Summary\n" + "4) EXIT");

    }




    public static void main(String[] args) {

        TestRepository repository = new TestRepository();
        TestExecutor executor = new TestExecutor();
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
