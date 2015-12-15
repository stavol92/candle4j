package com.vovnet.app.calc;

/**
 * Created by Vladimir Saykovsky on 14.12.2015.
 *
 * ѕроизводит расчеты на основании аргументов переданных при старте программы
 */
public class ArgRunner {

    private int first;
    private int second;
    private String operator;
    private Calculator calculator;

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("No args!");
        } else {
            ArgRunner runner = new ArgRunner(Integer.valueOf(args[0]), args[1], Integer.valueOf(args[2]));
            runner.start();
        }
    }

    /**
     * constructor
     * @param first     первое число
     * @param operator  математический оператор
     * @param second    второе число
     */
    public ArgRunner(int first, String operator, int second) {
        this.first = first;
        this.second = second;
        this.operator = operator;
        this.calculator = new Calculator();
    }

    /**
     * «апускает расчет
     */
    public void start() {
        calculate();
        printResult();
    }

    /**
     * ¬ыводит результат вычислений в консоль
     */
    private void printResult() {
        System.out.println(first + operator + second + " = " + calculator.getResult());
    }

    /**
     * ѕроизводит расчет
     */
    private void calculate() {
        switch (operator.charAt(0)) {
            // plus
            case 'p':
                calculator.add(first, second);
                break;
            // sub
            case 's':
                calculator.sub(first, second);
                break;
            // multiply
            case 'm':
                calculator.multiply(first, second);
                break;
            // divide
            case 'd':
                calculator.divide(first, second);
                break;
        }
    }
}
