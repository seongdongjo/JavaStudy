package ch03;

public class StringTest {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		
		//��, hashCode���� ���ٸ� ��ü�� �޶� ���ڿ��� �������� �ǹ��Ѵ�.
		//�ݸ鿡 System.identityHashCode()�� �������̵尡 �ȵǸ� ��ü�� ������ hashCode�� �����մϴ�. ��ü ��ü�� ���Ϸ��� �� �޼ҵ带 ����ϴ� ���� �����ϴ�.
		System.out.println(str1.hashCode()); //hashcode�� ����. ��? str1��str2�� �ٸ���ü�̱������� StringŬ�������� �ڵ����� hashCode�������̵��Ȱ��� ���� ���ڿ������� hashCode�� ����⶧���� ���� ����. 
		System.out.println(str2.hashCode());
		System.out.println(System.identityHashCode(str1)); //�ּҰ��� �ٸ���
		System.out.println(System.identityHashCode(str2)); //�ּҰ��� �ٸ���.
		System.out.println(str1 == str2);
		
		String str3 = "abc";
		String str4 = "abc";
		
		System.out.println(str3 == str4);
	}
}
