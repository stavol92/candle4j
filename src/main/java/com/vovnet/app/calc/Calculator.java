package com.vovnet.app.calc;

/**
 * Created by Vladimir Saykovsky on 14.12.2015.
 */
public class Calculator {

    private int result;

    /**
     * ���������� ���������� �����
     * @param params
     */
    public void add(int ... params) {
        for (Integer param : params) {
            this.result += param;
        }
    }

    /**
     * �������� ���������� �����
     * @param params
     */
    public void sub(int ... params) {
        for (Integer param : params) {
            this.result -= param;
        }
    }

    /**
     * �������� ���������� �����
     * @param params
     */
    public void multiply(int ... params) {
        for (Integer param : params) {
            this.result *= param;
        }
    }

    /**
     * ����� �� ���������� �����
     * @param params
     */
    public void divide(int ... params) {
        for (Integer param : params) {
            this.result /= param;
        }
    }

    /**
     * ���������� ��������� ����������
     * @return
     */
    public int getResult() {
        return this.result;
    }

    /**
     * ������������� ���������
     * @param result
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * ������� ���������
     */
    public void cleanResult() {
        this.result = 0;
    }
}
