package ch11;

public abstract class Calculator implements Calc{ //abstract�� �ٿ��ߵ�. implements�� ���̴¼��� 4���� �޼��带 �����ؾߵǴµ� 2���� ��������
	//��, implement�޼���� �ڵ����� abstract�� �ٱ⶧���� 4���� �� �������� ������ abstract�� Ŭ������ �������Ѵ�.

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}
}
