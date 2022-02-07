package ch03;

public class FunctionTest {
	public static int addNum(int num1, int num2) {
		int result;
		result = num1 + num2;
		return result;
	}
	
	public static void sayHello(String greeting) {
		System.out.println(greeting);
	}
	public static int calcSum() {
		int sum = 0;
		int i;
		for(i = 0; i<=100; i++) {
			sum += i; 
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int n1=10;
		int n2=20;
		
		int total = addNum(n1,n2);
		System.out.println(total);
		
		sayHello("안녕하세요");
		
		total = calcSum();
		System.out.println(total);
	}
}

//스택: 함수가 호출될 때 지역변수들이 사용하는 메모리
//스택: 함수의 수행이 끝나면 자동으로 반환되는 메모리

