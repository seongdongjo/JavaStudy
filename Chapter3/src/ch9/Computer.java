package ch9;

//�θ�
public abstract class  Computer { //�߻�Ŭ������ ��������� Ŭ������.
	
	//�޼��弱���ߴ�.(�߻�޼���)
	//��ӹ��� �ֵ��� ��ü������ ��� �������� �𸣱⶧���� display,typing�� �ڽ��� �˾Ƽ��ض�
	//��ǻ�ʹ� �������ξ� turnOn, turnOff�� �����ϰ� display(), typing()�� ���������ʾҴ�. ����Ŭ������ å������
	abstract void display();
	abstract void typing();
	
	//�Ϲݸ޼���
	public void turnOn() {
		System.out.println("������ �մϴ�.");
	}
	
	public void turnOff() {
		System.out.println("������ ���ϴ�.");
	}
}
