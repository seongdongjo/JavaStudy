package ch14;

public interface Calc {

	double PI = 3.14;
	int ERROR = -99999999;
	
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	default void description() {
		System.out.println("정수 계산기를 구현합니다.");
		myMethod(); 
	}
	
	static int total(int[] arr) { //arr의 합구하기
		int total = 0;
		
		for(int i: arr) {
			total += i;
		}
		mystaticMethod(); //static메서드에서 private static호출가능(private이기때문에 클래스안에서만)
		return total;
	}
	
	private void myMethod() { //버전때문에 지금 private는 안된다. 상속받은 CompleteCalc에서 구현하라고 에러가뜸
		System.out.println("private method");
	}
	
	private static void mystaticMethod() { 
		System.out.println("private static method");
	}
}
