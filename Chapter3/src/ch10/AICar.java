package ch10;

public class AICar extends Car{
	
	//Car���� ��ӹ��� �߻�޼��� drive, stop ����
	@Override
	public void drive() {
		System.out.println("���� �����մϴ�.");
		System.out.println("�ڵ����� ������ ������ �ٲߴϴ�.");
	}

	@Override
	public void stop() {
		System.out.println("������ ����ϴ�.");		
	}

	@Override
	public void washCar() {
		System.out.println("�ڵ� ������ �մϴ�.");
	}
	
	
}
