package ch06;

public class Student { //��������� �˾Ƽ� �ʱ�ȭ�ȴ�. null, 0
	public int studentNumber;
	public String studentName;
	public int grade;
	
	public Student() {
		System.out.println("������");
	}
	
	public Student(int studentNumber, String studentName, int grade) {
		this.studentNumber = studentNumber; //�����̸��� �ٸ��� this�����ʿ䰡����
		this.studentName = studentName;
		this.grade = grade;
	}
	
	public String showStudentInfo() {
		int i; //i�� �ʱ�ȭ���� �ʴ´�.(����������)
		return studentName + "�л��� �й���" + studentNumber + "�̰�, " + grade + "�г� �Դϴ�.";
	}
}
