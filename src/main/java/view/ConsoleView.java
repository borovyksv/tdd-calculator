package view;

import java.util.Scanner;

public class ConsoleView implements View {
    private boolean done;

    @Override
    public void run() {
        while (!done) {
            Scanner scanner = new Scanner(System.in);
            Double first = getNumber(scanner, "Enter first number:");
            Double second = getNumber(scanner, "Enter second number:");
            String operator = getOperator(scanner, "Enter operator:");

            addInput(first, second, operator);
            notifyObservers();
            done = getIsDone(scanner);
        }
    }

    private void addInput(Double first, Double second, String operator) {
        inputs.add(new Input(first, second, operator));
    }

    private Double getNumber(Scanner scanner, String message) {
        print(message);
        return scanner.nextDouble();
    }

    private String getOperator(Scanner scanner, String message) {
        print(message);
        return scanner.next();
    }

    private Boolean getIsDone(Scanner scanner) {
        print("-------------------");
        print("Continue? Y/N");
        return !"Y".equalsIgnoreCase(scanner.next());
    }

    public void printResult(Double result) {
        print("Your result = " + result);
    }

    protected void print(String s) {
        System.out.println(s);
    }
}
