package ch02;

public class EqualTest {

	public static void main(String[] args) throws CloneNotSupportedException { //cloneable�����ʴµ� clone�Ҷ� ���ܹ߻�ó��
		Student Lee = new Student(100, "Lee");
		Student Lee2 = Lee;
		Student Shun = new Student(100, "Lee");
		
		System.out.println(Lee == Shun); // ���� Ŭ������ ��������� false�� ���´�. �ٸ� ��ü�̱⶧����
		System.out.println(Lee.equals(Shun)); //������ ���ϸ� false�� ���´�. equals�� ���� �����Ǹ� ���ϸ� �ּҰ��� �����ĸ� ���°��̴�. �ٵ� �츮�� �����Ǹ� �ߴ�
		System.out.println(Lee == Lee2); //true
		
		System.out.println(Lee.hashCode()); //917~  ���� �޸��ּҰ� �ٸ��⶧����
		System.out.println(Shun.hashCode()); //199~ �ٸ����� ���´�.
		//������ �츮�� hashCode()�� ������ �߱⶧���� �������̳��´�(Studentid)
		
		//�׷��ٰ� ������ �������ִ� hashCode()�� �������� �ʴ´�.
		//System.out.println(System.identityHashCode(Lee));
		//System.out.println(System.identityHashCode(Shun));
		
		//�̿Ͱ��� ������� Integer, String�� ���Ͱ��� equals, hashCode�� �������̵��� �Ǿ��ִ�.
		//�׷��� �Ʒ��Ͱ��� ���´�.
		Integer i1 = new Integer(100); //String str1 = new String("abc");
		Integer i2 = new Integer(100); //String str2 = new String("abc");
		
		System.out.println(i1.equals(i2)); //true
		System.out.println(i1.hashCode()); //100
		System.out.println(i2.hashCode()); //100
		
		System.out.println(System.identityHashCode(i1)); //�ּҰ��� �ٸ���
		System.out.println(System.identityHashCode(i2)); //�ּҰ��� �ٸ���.
		
		Lee.setStudentName("kim");
		Student Lee3 = (Student)Lee.clone(); //Ŭ���� returnŸ���� object�̱⶧���� �ٿ�ĳ����
		System.out.println(Lee3); //100,kim ���� ���´�. ��, �����ϸ� �ٰ����´�.
		
		System.out.println(System.identityHashCode(Lee)); //������ �ص� �ּҰ����ٸ���.
		System.out.println(System.identityHashCode(Lee3)); //���� �ٸ���.
		
		
		
	}
}
