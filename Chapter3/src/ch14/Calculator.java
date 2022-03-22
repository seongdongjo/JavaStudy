package ch14;

public abstract class Calculator implements Calc{ //implements를 하면 4개 함수 (add등)다 구현해야하는데 2개만해서 abstract붙혔다.

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}
}
