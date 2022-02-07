package ch14;

public class TakeTransTest {

	public static void main(String[] args) {
		Student studentJ = new Student("James", 5000);
		Student studentT = new Student("Tomas", 10000);
		
		Bus bus100 = new Bus(100);  //�����ѹ�
		Bus bus500 = new Bus(500);
		
		studentJ.takeBus(bus100); //studentJ�� bus100�� ����.
		
		Subway greenSubway = new Subway(2); //lineNumber
		studentT.takeSubway(greenSubway);
		
		studentJ.showInfo();
		studentT.showInfo();
		
		bus100.showBusInfo();
		greenSubway.showsubwayInfo();
	}

	/*
	 * James���� ���� ���� 4000�� �Դϴ�. 
	 * Tomas���� ���� ���� 8800�� �Դϴ�. 
	 * 100���� �°� ���� 1�� �̰�, ������
	 * 1000�� �Դϴ�. 2���� �°� ���� 1�� �̰�, ������ 1200�� �Դϴ�.
	 */
}
