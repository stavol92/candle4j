package com.vovnet.app.calc;

public class Calculate {
	
	public static void main(String[] arg) {
		Calculate calculate = new Calculate();
	}
	
	// сложение
	public int add(int a, int b) {
		return a + b;
	}
	
	// вычитание
	public int sub(int a, int b) {
		return a - b;
	}
	
	// умножение
	public int multy(int a, int b) {
		return a * b;
	}
	
	// деление
	public int div(int a, int b) {
		return a / b;
	}
	
	// возведение в степень
	public int invol(int a, int b) {
		int res = a;
		for (int i = 1; i < b; i++) {
			res *= a;
		}
		return res;
	}
}