package taxi;

public class Student {
	String studentName;
	int grade;
	int money;
	
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	
	public void takeTaxi(Taxi taxi) {
		taxi.take(10000);  //taxi∞¥√º money¡ı∞°
		this.money -= 10000;
	}
	
	public void showInfo() {
		System.out.println(studentName + "¥‘¿« ≥≤¿∫ µ∑¿∫ " + money + "ø¯ ¿‘¥œ¥Ÿ.");
	}
}
