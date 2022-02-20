package ch10;

public abstract class Car {
	
	public abstract void drive(); //AI, ���������� drive�޼���� �ڽ��� �����ض�
	public abstract void stop(); //��������
	
	//�õ��� �����̴ϱ� ��������
	public void startCar() {
		System.out.println("�õ��� �մϴ�.");
	}
	
	public void turnOff() {
		System.out.println("�õ��� ���ϴ�.");
	}
			
	public void washCar() {} //�����Ǳ��ߴ�.
	
	final public void run() {
		//�õ����ɰ� �����ϴٰ� ���̻���� ���߰� �õ����� -> �ó�����(�̰Ŵ� ���ϸ�ȵȴ�) -> run�޼��带 �������ϸ�ȵǴϱ� final�� ����
		startCar(); //�Ϲ�
		drive(); //�߻�
		stop(); //�߻� 
		turnOff(); //�Ϲ�
		washCar(); //�������Ҽ��ְԲ�(ai������ �ᵵ��), �Ϲ��ڵ����� �����Ǿ�����
	}
}