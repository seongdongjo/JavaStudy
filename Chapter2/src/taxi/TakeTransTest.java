package taxi;

public class TakeTransTest {

	public static void main(String[] args) {
		Student studentE = new Student("Edward", 20000);
		Taxi wellTaxi = new Taxi("잘 간다 운수");
		studentE.takeTaxi(wellTaxi);
		
		studentE.showInfo();
		wellTaxi.showTaxiInfo();
	}

	/*
	 * Edward님의 남은 돈은 10000원 입니다. 잘 간다 운수택시 수입은 10000원 입니다.
	 */
}
