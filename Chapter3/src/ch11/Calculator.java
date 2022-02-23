package ch11;

public abstract class Calculator implements Calc{ //abstract를 붙여야됨. implements를 붙이는순간 4개의 메서드를 구현해야되는데 2개만 구현했음
	//또, implement메서드는 자동으로 abstract가 붙기때문에 4개를 다 구현하지 않으면 abstract로 클래스를 만들어야한다.

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}
}
