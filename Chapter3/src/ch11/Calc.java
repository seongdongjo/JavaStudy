package ch11;

public interface Calc {

	double PI = 3.14;
	int ERROR = -99999999;
	
	int add(int num1, int num2); //인터페이스는 abstract와 달리 상속이아니라 구현이라는 것이다.(Calculator에서 구현해야됨)
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
}