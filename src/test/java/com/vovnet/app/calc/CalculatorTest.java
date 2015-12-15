package com.vovnet.app.calc;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vladimir on 15.12.2015.
 *
 * Test Calculator.java
 */
public class CalculatorTest {

    @Test
    public void testAdd() throws Exception {
        Calculator calc = new Calculator();
        calc.add(3, 5);
        int result = calc.getResult();
        assertEquals(8, result);
    }

    @Test
    public void testSub() throws Exception {
        Calculator calc = new Calculator();
        calc.sub(2);
        int result = calc.getResult();
        assertEquals(-2, result);
    }

    @Test
    public void testMultiply() throws Exception {
        Calculator calc = new Calculator();
        calc.add(2, 2, 2);
        int result = calc.getResult();
        assertEquals(6, result);
    }

    @Test
    public void testDivide() throws Exception {
        Calculator calc = new Calculator();
        calc.divide(3, 5);
        int result = calc.getResult();
        assertEquals(0, result);
    }

    @Test
    public void testGetResult() throws Exception {
        Calculator calc = new Calculator();
        int result = calc.getResult();
        assertEquals(0, result);
    }

    @Test
    public void testCleanResult() throws Exception {
        Calculator calc = new Calculator();
        calc.add(3, 5);
        calc.cleanResult();
        int result = calc.getResult();
        assertEquals(0, result);
    }
}