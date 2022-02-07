package ch14;

public class Subway {
	int lineNumber;
	int passengerCount; //½Â°´¼ö
	int money;
	
	public Subway(int busNumber) {
		this.lineNumber = busNumber;
	}
	
	public void take(int money) {
		this.money = money;
		passengerCount++;
	}
	
	public void showsubwayInfo() {
		System.out.println(lineNumber + "¹øÀÇ ½Â°´ ¼ö´Â " + passengerCount + "¸í ÀÌ°í, ¼öÀÔÀº " + money + "¿ø ÀÔ´Ï´Ù.");
	}
}
