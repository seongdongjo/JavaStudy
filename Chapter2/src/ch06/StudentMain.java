package ch06;

public class StudentMain {
	public static void main(String[] args) {
		Student studentLee = new Student();
		Student studentKim = new Student(123456, "Kim", 3);
		
		System.out.println(studentKim.showStudentInfo()); 
		
		System.out.println(studentLee.showStudentInfo()); //null,0~
	}
}
