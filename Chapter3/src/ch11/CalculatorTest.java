package ch11;

import java.util.Scanner;

public class CalculatorTest {

	public static void main(String[] args) {
		Calc calc = new CompleteCalc();
		int num1 = 10;
		int num2 = 2;
		
		System.out.println(num1 + "+" + num2 + "=" + calc.add(num1, num2));
		System.out.println(num1 + "-" + num2 + "=" +calc.substract(num1, num2));
		System.out.println(num1 + "*" + num2 + "=" +calc.times(num1, num2));
		System.out.println(num1 + "/" + num2 + "=" +calc.divide(num1, num2));
		
		for(int i = 0; i<5; i++) {
			for(int j=0; j<4-i; j++) {
					System.out.print(" ");
			}
			for(int j=0; j<=i*2; j++) {
				if (j==0 || j==i*2 || i ==2){
					System.out.print("*");
				}
				else
					System.out.print(" ");
				}
			System.out.println();
	}
}
}
