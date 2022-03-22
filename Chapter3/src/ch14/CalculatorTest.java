package ch14;

public class CalculatorTest {

	public static void main(String[] args) {
		Calc calc = new CompleteCalc();
		int num1 = 10;
		int num2 = 2;
		
		System.out.println(num1 + "+" + num2 + "=" + calc.add(num1, num2));
		System.out.println(num1 + "-" + num2 + "=" +calc.substract(num1, num2));
		System.out.println(num1 + "*" + num2 + "=" +calc.times(num1, num2));
		System.out.println(num1 + "/" + num2 + "=" +calc.divide(num1, num2));
	
		calc.description();
		
		int[] arr = {1,2,3,4,5};
		int sum = Calc.total(arr); //total이라는 정적메서드이기때문에 바로 클래스를 호출했다.(private로 선언된 mystaticMethod도 호출했다 total에 같이선언되있으니)
		System.out.println(sum);
	}
}
