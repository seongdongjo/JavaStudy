package ch04;

public class MainStudent {
	public static void main(String[] args) {
		Student studentLee = new Student(); //�ν��Ͻ�����Ѵ�, ���� ��Ű���������� import ���Ѵ�
		Student studentKim = new Student();
		
		//�ν��Ͻ�����(studentLee, studentKim) �����޸�(Heap)�� �Ҵ�ȴ�.
		//c�� c++������ ����� �����޸𸮸� ���α׷��Ӱ� �������Ѿ��Ѵ�.(free, delete)
		//�ڹٿ����� �������÷��Ͱ� �ֱ������� ������� �ʴ� �޸𸮸� �����Ѵ�.
		//�ϳ��� Ŭ�����κ��� �������� �ν��Ͻ��� �����ǰ� ���� �ٸ� �޸� �ּҸ� ������ �ȴ�.
		
		studentLee.studentID = 12345;
		studentLee.setStudentName("Lee");
		studentLee.address = "���� ������";
		
		studentLee.showStudentInfo();
		
		System.out.println(studentKim); //ch04.Student@36aa7bc2 -> ��ü�� ��ġ�� ����Ű��(Heap�� �ִ� �ν��Ͻ��� ����Ų��) �ּҰ��̴�. (������ �޸��ּҰ� �ƴ϶� JVM�� �� ���� �ּ�)
		//�׷��� studentKim. (��.)�� �������ν� ����
		System.out.println(studentLee);
		
		//�ν��Ͻ� : new Ű���带 ����Ͽ� Ŭ������ �޸𸮿� ������ ����
		//��������: �޸𸮿� ������ �ν��Ͻ��� ����Ű�� ����
		//������: ������ �ν��Ͻ��� �޸� �ּҰ�
	}
}
