package com.vovnet.app.calc;

import java.util.Scanner;

/**
 * Created by Vladimir on 14.12.2015.
 *
 * Calculates user input.
 */
public class InteractRunner {

    private Scanner scanner;
    private boolean isClean;
    private int firstNumber;
    private int secondNumber;
    private String operation;
    private Calculator calculator;
    private String exit;
    private String clean;

    public static void main(String[] args) {
        InteractRunner runner = new InteractRunner();
        runner.start();
    }

    /**
     * Constructor
     */
    public InteractRunner() {
        scanner = new Scanner(System.in);
        calculator = new Calculator();
        this.isClean = true;
        exit = "no";
    }

    /**
     * Start the calculator
     */
    public void start() {
        while (!exit.equals("yes")) {
            requestData();
            calculate();
            System.out.println("Result is: " + calculator.getResult());
            requestClean();
            requestExitApp();
        }
    }

    /**
     * Ask the user "Exit the app?"
     */
    public void requestExitApp() {
        System.out.println("Exit? yes/no");
        exit = scanner.next();
        if (!validateYesNo(exit)) {
            requestExitApp();
        }
    }

    /**
     * Ask the user "Clean the result?"
     */
    private void requestClean() {
        System.out.println("Clean result? yes/no");
        clean = scanner.next();
        if (validateYesNo(clean)) {
            cleanResult();
        } else {
            requestClean();
        }
    }

    /**
     * Cleaning the result
     */
    private void cleanResult() {
        if (clean.equals("yes")) {
            calculator.cleanResult();
            this.isClean = true;
        } else {
            this.isClean = false;
        }
    }

    /**
     * Requests the user data
     */
    private void requestData() {
        if (this.isClean) {
            System.out.println("Enter first arg: ");
            this.firstNumber = Integer.valueOf(scanner.next());
        } else {
            this.firstNumber = 0;
        }

        requestOperator();

        System.out.println("Enter second arg: ");
        this.secondNumber = Integer.valueOf(scanner.next());
    }

    /**
     * Validate the user answer by "yes/no"
     * @param str   the user string
     * @return      true, if user answer is "yes" or "no"
     */
    private boolean validateYesNo(String str) {
        boolean isValid = true;
        if (!str.equals("yes") && !str.equals("no")) {
            isValid = false;
        }
        return isValid;
    }

    /**
     * Request the user input operator
     */
    private void requestOperator() {
        System.out.println("Choose the operation: plus/p, sub/s, multi/m, divide/d");
        this.operation = scanner.next();
        if (!validateOperator()) {
            requestOperator();
        }
    }

    /**
     * Check the operator input by user
     * @return true, if operator is valid
     */
    private boolean validateOperator() {
        boolean isValid = true;
        char charAt = this.operation.charAt(0);
        if (charAt != 'p' && charAt != 's' && charAt != 'm' && charAt != 'd') {
            isValid = false;
        }
        return isValid;
    }

    /**
     * Calculating
     */
    private void calculate() {
        switch (operation.charAt(0)) {
            case 'p':
                calculator.add(this.firstNumber, this.secondNumber);
                break;
            case 's':
                calculator.sub(this.firstNumber, this.secondNumber);
                break;
            case 'm':
                if (this.isClean) calculator.multiply(this.firstNumber);
                calculator.multiply(this.secondNumber);
                break;
            case 'd':
                if (this.firstNumber != 0) calculator.divide(this.firstNumber);
                if (this.secondNumber != 0) calculator.divide(this.secondNumber);
                break;
        }
    }


}
