package com.vovnet.app.calc;

/**
 * Created by Vladimir Saykovsky on 14.12.2015.
 */
public class Calculator {

    private int result;

    /**
     * Складывает переданные числа
     * @param params
     */
    public void add(int ... params) {
        for (Integer param : params) {
            this.result += param;
        }
    }

    /**
     * Вычитает переданные числа
     * @param params
     */
    public void sub(int ... params) {
        for (Integer param : params) {
            this.result -= param;
        }
    }

    /**
     * Умножает переданные числа
     * @param params
     */
    public void multiply(int ... params) {
        for (Integer param : params) {
            this.result *= param;
        }
    }

    /**
     * Делит на переданные числа
     * @param params
     */
    public void divide(int ... params) {
        for (Integer param : params) {
            this.result /= param;
        }
    }

    /**
     * Возвращает результат вычислений
     * @return
     */
    public int getResult() {
        return this.result;
    }

    /**
     * Устанавливает результат
     * @param result
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * Очищает результат
     */
    public void cleanResult() {
        this.result = 0;
    }
}
