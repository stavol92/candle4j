package com.vovnet.app.calc;

import java.util.Scanner;

/**
 * Created by Vladimir Saykovsky on 14.12.2015.
 *
 * Калькулятор запрашивающий данные для расчетов с консоли.
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
     * constructor
     */
    public InteractRunner() {
        scanner = new Scanner(System.in);
        calculator = new Calculator();
        this.isClean = true;
        exit = "no";
    }

    /**
     * Запуск калькулятора
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
     * Спрашивает у пользователя завершить ли работу программе
     */
    public void requestExitApp() {
        System.out.println("Exit? yes/no");
        exit = scanner.next();
        if (!validateYesNo(exit)) {
            requestExitApp();
        }
    }

    /**
     * Запрос на очистку данных
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
     * Очищает результаты
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
     * Запрашивает у пользователя данные
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
     * Проверяет на валидность введенную строку на соответствие "yes/no"
     * @param str   строка с текстом
     * @return      true, если строка соответствует "yes" или "no"
     */
    private boolean validateYesNo(String str) {
        boolean isValid = true;
        if (!str.equals("yes") && !str.equals("no")) {
            isValid = false;
        }
        return isValid;
    }

    /**
     * Запрашивает у пользователя математический оператор
     */
    private void requestOperator() {
        System.out.println("Choose the operation: plus/p, sub/s, multi/m, divide/d");
        this.operation = scanner.next();
        if (!validateOperator()) {
            requestOperator();
        }
    }

    /**
     * Проверяет на валидность введенный пользователем оператор
     * @return true, если оператор валидный
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
     * Производит расчет
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
