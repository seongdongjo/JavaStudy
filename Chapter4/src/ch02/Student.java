package ch02;

public class Student implements Cloneable{

	private int studentId;
	private String studentName;

	public Student(int studentId, String studentName)
	{
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public boolean equals(Object obj) {
		if( obj instanceof Student) { //넘어온 객체가 Student인가
			Student std = (Student)obj; //그렇다면 obj를 Student로 다운캐스팅
			if(this.studentId == std.studentId ) //id로 똑같은 학생인지 확인(주소가 서로달라도) 즉, 주소가(물리적)달라도 논리적으로 같다. 
				return true;
			else return false;
		}
		return false;
		
	}
	
	public void setStudentName(String name) {
		this.studentName = name;
	}
	@Override
	public int hashCode() {
		return studentId;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
}
