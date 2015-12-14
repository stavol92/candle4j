public class Calculate {
	
	public static void main(String[] arg) {
		System.out.println("Hello! Calculating...");
		int first = Integer.valueOf(arg[0]);
		int second = Integer.valueOf(arg[1]);
		int res = invol(first, second);
		System.out.println("Result: " + res);
	}
	
	// сложение
	public static int add(int a, int b) {
		return a + b;
	}
	
	// вычитание
	public static int sub(int a, int b) {
		return a - b;
	}
	
	// умножение
	public static float multy(float a, float b) {
		return a * b;
	}
	
	// деление
	public static double div(double a, double b) {
		return a / b;
	}
	
	// возведение в степень
	public static int invol(int a, int b) {
		int res = a;
		for (int i = 1; i < b; i++) {
			res *= a;
		}
		return res;
	}
}