package ch14;

public abstract class Calculator implements Calc{ //implements�� �ϸ� 4�� �Լ� (add��)�� �����ؾ��ϴµ� 2�����ؼ� abstract������.

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}
}
