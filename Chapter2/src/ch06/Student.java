package ch06;

public class Student { //멤버변수는 알아서 초기화된다. null, 0
	public int studentNumber;
	public String studentName;
	public int grade;
	
	public Student() {
		System.out.println("생성자");
	}
	
	public Student(int studentNumber, String studentName, int grade) {
		this.studentNumber = studentNumber; //변수이름이 다르면 this붙일필요가없다
		this.studentName = studentName;
		this.grade = grade;
	}
	
	public String showStudentInfo() {
		int i; //i는 초기화되지 않는다.(지역변수라서)
		return studentName + "학생의 학번은" + studentNumber + "이고, " + grade + "학년 입니다.";
	}
}
