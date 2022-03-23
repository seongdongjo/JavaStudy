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
		if( obj instanceof Student) { //�Ѿ�� ��ü�� Student�ΰ�
			Student std = (Student)obj; //�׷��ٸ� obj�� Student�� �ٿ�ĳ����
			if(this.studentId == std.studentId ) //id�� �Ȱ��� �л����� Ȯ��(�ּҰ� ���δ޶�) ��, �ּҰ�(������)�޶� �������� ����. 
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
