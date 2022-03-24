package ch04;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
						ClassNotFoundException, NoSuchMethodException, SecurityException {
		//�������
		Person person = new Person("James");
		System.out.println(person); //James
		
		//�����ε�
		//Class.forName("Ŭ�����̸�") �޼���� Ŭ������ �������� �ε���(��Ÿ�ӽÿ�)
		
		//Class c = String.class; Ŭ���� �̸����� ���� Class��������
		
		//������ �ν��Ͻ����� Class Ŭ���� ��������
		//String s = new String();
		//Class c = s.getClass(); 
		
		Class c1 = Class.forName("ch04.Person"); //class�� �������� ��� 1
		Person person1 = (Person)c1.newInstance(); //��ȯ���� ������Ʈ��
		person1.setName("Lee");
		System.out.println(person1); //Lee ���(�������̵�������)
		
		//class�� �������� ���2
		//�Ʒ������� ���������� Person kim2 = new Person("������"); �� ����.
		//�̷��Ŵ� local�� Person�̶�� Ŭ������ ���� �� ���°��̴�.
		Class c2 = person1.getClass(); //getClass�� ������ �̹� �ν��Ͻ��� �ִ»��¿����Ѵ�.
		Person p = (Person)c2.newInstance();
		System.out.println(p); //null���
		
		Class[] parameterTypes = {String.class};  //person�̶�� Ÿ���� Ŭ������ ���µ� 
		Constructor cons = c2.getConstructor(parameterTypes); //constructor������ �����ͼ� ��ȯ���ش�. 
		
		Object[] initargs = {"������"};
		Person personLee = (Person)cons.newInstance(initargs);
		System.out.println(personLee); //������ ���
		
		//�̷��� reflection ���α׷����ε�
		//Class Ŭ������ ����Ͽ� Ŭ������ ����(������, ����, �޼���)���� �˼��ְ� �ν��Ͻ��� �����ϰ�, �޼��带 ȣ���ϴ� ����� ���α׷���
		//���ø޸𸮿� ��ü���°��, �������α׷���, ��ü�� Ÿ���� �˼����� ��쿡 ���
		
		
	}
}
