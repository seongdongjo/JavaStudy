package ch14;

public class TakeTransTest {

	public static void main(String[] args) {
		Student studentJ = new Student("James", 5000);
		Student studentT = new Student("Tomas", 10000);
		
		Bus bus100 = new Bus(100);  //버스넘버
		Bus bus500 = new Bus(500);
		
		studentJ.takeBus(bus100); //studentJ가 bus100을 탔다.
		
		Subway greenSubway = new Subway(2); //lineNumber
		studentT.takeSubway(greenSubway);
		
		studentJ.showInfo();
		studentT.showInfo();
		
		bus100.showBusInfo();
		greenSubway.showsubwayInfo();
	}

	/*
	 * James님의 남은 돈은 4000원 입니다. 
	 * Tomas님의 남은 돈은 8800원 입니다. 
	 * 100번의 승객 수는 1명 이고, 수입은
	 * 1000원 입니다. 2번의 승객 수는 1명 이고, 수입은 1200원 입니다.
	 */
}
