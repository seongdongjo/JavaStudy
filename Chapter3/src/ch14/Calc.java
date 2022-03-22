package ch14;

public interface Calc {

	double PI = 3.14;
	int ERROR = -99999999;
	
	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	default void description() {
		System.out.println("���� ���⸦ �����մϴ�.");
		myMethod(); 
	}
	
	static int total(int[] arr) { //arr�� �ձ��ϱ�
		int total = 0;
		
		for(int i: arr) {
			total += i;
		}
		mystaticMethod(); //static�޼��忡�� private staticȣ�Ⱑ��(private�̱⶧���� Ŭ�����ȿ�����)
		return total;
	}
	
	private void myMethod() { //���������� ���� private�� �ȵȴ�. ��ӹ��� CompleteCalc���� �����϶�� ��������
		System.out.println("private method");
	}
	
	private static void mystaticMethod() { 
		System.out.println("private static method");
	}
}
