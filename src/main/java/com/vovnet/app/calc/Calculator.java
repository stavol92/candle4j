package com.vovnet.app.calc;

/**
 * Created by Vladimir on 14.12.2015.
 */
class Calculator {

    private int result;

    /**
     * Summarizes the numbers
     * @param params numbers
     */
    public void add(int ... params) {
        for (Integer param : params) {
            this.result += param;
        }
    }

    /**
     * Subtracts the numbers
     * @param params numbers
     */
    public void sub(int ... params) {
        for (Integer param : params) {
            this.result -= param;
        }
    }

    /**
     * Multiplies the numbers
     * @param params numbers
     */
    public void multiply(int ... params) {
        for (Integer param : params) {
            this.result *= param;
        }
    }

    /**
     * Divides the numbers
     * @param params numbers
     */
    public void divide(int ... params) {
        for (Integer param : params) {
            this.result /= param;
        }
    }

    /**
     * Return the result
     * @return the result
     */
    public int getResult() {
        return this.result;
    }

    /**
     * Clean the result
     */
    public void cleanResult() {
        this.result = 0;
    }
}
